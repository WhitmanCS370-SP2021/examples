// Which version is better? (exercise 2.18, p. 44)

// Version 1
public class SSNWrapper {
  private int SocialSecurityNumber;
  public SSNWrapper(int ssn)         { socialSecurityNumber = SSN;}
  public int getSSN()                { return SSN; }
  protected void setSSN(int SSN)     { socialSecurityNumber = SSN; }
} 
public class SettableSSNWrapper extends SSNWrapper {
  public SettableSSNWrapper(int ssn) { super(ssn); }
  public void setSSN(int ssn)        { super.setSSN(ssn); }
}

// Version 2
public class SSNWrapper {
  protected int SocialSecurityNumber;
  public SSNWrapper(int ssn)         { socialSecurityNumber = SSN;}
  public int getSSN()                { return SSN; }
} 
public class SettableSSNWrapper extends SSNWrapper {
  public SettableSSNWrapper(int ssn) { super(ssn); }
  public void setSSN(int ssn)        { socialSecurityNumber = SSN; }
}

