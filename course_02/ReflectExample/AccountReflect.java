import java.lang.reflect.*;

public class AccountReflect {
    public Object copy(Object object) throws Exception {
        Class classType = object.getClass();
        System.out.println("Class " + classType.getName());
        
        Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[]{});
        Field fields[] = classType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0,1).toUpperCase();

            String getMethodName = "get" + firstLetter + fieldName.substring(1);
            String setMethodName = "set" + firstLetter + fieldName.substring(1);

            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});

            Object value = getMethod.invoke(object, new Object[]{});
            System.out.println(fieldName+":"+value);
            setMethod.invoke(objectCopy, new Object[]{value});
        }

        return objectCopy;
    }

    public static void main(String[] args) throws Exception {
        Account account = new Account("Zhang3", 1000);
        Account accountCopy = (Account)new AccountReflect().copy(account);
        System.out.println("Copy information: " + accountCopy.getName() + " " + accountCopy.getBalance());
    }
}

class Account {
    private String name;
    private int balance;

    public Account() {}
    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}
