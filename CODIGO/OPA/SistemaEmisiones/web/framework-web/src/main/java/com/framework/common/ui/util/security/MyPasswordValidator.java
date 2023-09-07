/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.util.security;

import com.quasar.frameq.db.AppConfigParams;
import com.quasar.frameq.exception.FrameworkSistemaException;
import com.framework.common.service.security.HistoryRuleQuasar;
import edu.vt.middleware.crypt.digest.MD5;
import edu.vt.middleware.crypt.util.Convert;
import edu.vt.middleware.crypt.util.HexConverter;
import edu.vt.middleware.dictionary.ArrayWordList;
import edu.vt.middleware.dictionary.WordListDictionary;
import edu.vt.middleware.dictionary.sort.ArraysSort;
import edu.vt.middleware.password.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Roger Padilla C.
 */
public class MyPasswordValidator {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private MessageResolver msgResolver;
  private List<Rule> ruleList;

  private MyPasswordValidator() {
    initMessageResolver();
    initRuleList();
  }

  private void initMessageResolver() {
    Properties props = new Properties();
    InputStream is = null;
    try {
      is = MyPasswordValidator.class.getResourceAsStream("/password_messages.properties");
      props.load(is);
    } catch (IOException exc) {
      logger.error(exc.getMessage(), exc);
      throw new FrameworkSistemaException(exc.getMessage(), exc);
    } finally {
      try {
        is.close();
      } catch (IOException exc) {
        logger.error(exc.getMessage(), exc);
      }
    }
    msgResolver = new MessageResolver(props);
  }

  private void initRuleList() {

    // don't allow whitespace
    WhitespaceRule whitespaceRule = new WhitespaceRule();

    // don't allow numerical sequences of length 3
    NumericalSequenceRule numSeqRule = new NumericalSequenceRule(4 , false);

    // don't allow alphabetical sequences
    AlphabeticalSequenceRule alphaSeqRule = new AlphabeticalSequenceRule(4 ,false);

    // don't allow 4 repeat characters
    RepeatCharacterRegexRule repeatRule = new RepeatCharacterRegexRule(4);

    // password must be between 8 and 16 chars long
    LengthRule lengthRule = new LengthRule(8, 16);

    /* create a case sensitive word list and sort it
    ArrayWordList awl = new ArrayWordList(
            AppConfigParams.getInstance().getGeneric().getPasswordBlackList(),
            false,
            new ArraysSort());

    // create a dictionary for searching
    WordListDictionary dict = new WordListDictionary(awl);

    DictionarySubstringRule dictRule = new DictionarySubstringRule(dict);
    dictRule.setWordLength(4); // size of words to check in the password
    dictRule.setMatchBackwards(true); // match dictionary words backwards*/

//    HistoryRule historyRule = new HistoryRule();
//    historyRule.setDigest("MD5", new HexConverter());

    HistoryRuleQuasar historyRule = new HistoryRuleQuasar();
    historyRule.setDigest("MD5", new HexConverter());//se pone para que sirva la comparacion con AES la hace en el validate

    // control allowed characters
    CharacterCharacteristicsRule charRule = new CharacterCharacteristicsRule();
    // require at least 1 digit in passwords
    charRule.getRules().add(new DigitCharacterRule(1){
      
      @Override
      protected String getCharacterType() {
        return "digito";
      }
    });
    // require at least 1 non-alphanumeric char
    charRule.getRules().add(new NonAlphanumericCharacterRule(1) {
      
      @Override
      protected String getCharacterType() {
        return "no alfanumérico";
      }
    });//Compilo para provar
    // require at least 1 upper case char
    charRule.getRules().add(new UppercaseCharacterRule(1){
      
      @Override
      protected String getCharacterType() {
        return "mayúsculas";
      }
    }); 
    // require at least 1 lower case char
    charRule.getRules().add(new LowercaseCharacterRule(1){
      
      @Override
      protected String getCharacterType() {
        return "minúsculas";
      }
    });
    // require at least 3 of the previous rules be met
    charRule.setNumberOfCharacteristics(3);

    // group all rules together in a List
    ruleList = new ArrayList<Rule>();
    ruleList.add(whitespaceRule);
    ruleList.add(numSeqRule);
    ruleList.add(alphaSeqRule);
    ruleList.add(repeatRule);
    ruleList.add(lengthRule);
    //ruleList.add(dictRule);
    ruleList.add(historyRule);
    ruleList.add(charRule);
  }

  public ValidationResult validate(String password, List<String> history) {

    logger.debug("OPA - " + password);
    logger.debug("OPA - " + history == null ? "history NULL" : history.toString());

    PasswordValidator validator = new PasswordValidator(msgResolver, ruleList);
    PasswordData passwordData = new PasswordData(new Password(password));
    passwordData.setPasswordHistory(history);

    RuleResult result = validator.validate(passwordData);

    boolean valid = result.isValid();
    List<String> messages = validator.getMessages(result);

    ValidationResult validationResult = new ValidationResult(valid, messages);

    return validationResult;
  }

  public boolean validar(String rawPassword, String encryptedPassword) {
    String hash = new MD5().digest(Convert.toBytes(rawPassword), new HexConverter());
    logger.debug("OPA - " + rawPassword);
    logger.debug("OPA - " + encryptedPassword);
    return hash.equals(encryptedPassword);
  }

  public static MyPasswordValidator getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    public static final MyPasswordValidator INSTANCE = new MyPasswordValidator();
  }

  public class ValidationResult {

    private boolean valid;
    private List<String> messages;

    public ValidationResult(boolean valid, List<String> messages) {
      this.valid = valid;
      this.messages = messages;
    }

    public boolean isValid() {
      return valid;
    }

    public List<String> getMessages() {
      return messages;
    }

  }
}
