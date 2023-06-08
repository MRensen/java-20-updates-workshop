public class PatternMatching {
    private record Person (String name, int age){};
    private record Team (String name, Person[] members){};
    private record GroupOfThree(Person one, Person two, Person three){};

    public static void main(String[] args) {
        Person person = new Person("Tim", 34);
        Person person2 = new Person("Zayd", 65);
        Person person3 = new Person("Karin", 12);
        oldRecordCheck(person);
        newRecordCheck(person);
        forLoop(new Person[]{person, person2});
        nestedPattern(new Team("myteam", new Person[]{person, person2}));
        nestedPattern(new GroupOfThree(person, person2, person3));
        switchMatch(new Team("myteam", new Person[]{person, person2}));
        switchMatch(new Team("notmyteam", new Person[]{person, person2}));
        switchMatch(person);
        switchMatch("This returns 'no name'");
    }

    public static void oldRecordCheck(Object obj){
        if(obj instanceof Person){
            System.out.println(((Person) obj).name());
        }
    }

   public static void newRecordCheck(Object obj){
       if(obj instanceof Person (String name, int age)){
           System.out.println(name);
       }
   }

   public static void forLoop(Person[] list){
        for (Person(String name, int age): list){
            System.out.println("Hi, I am " + name);
        }
   }

   public static void nestedPattern(Object obj){
        if(obj instanceof GroupOfThree(Person(String nameOne, int ageOne),
                                       Person(String nameTwo, int ageTwo),
                                       Person(String nameThree, int ageThree))){
            System.out.println("NEW: The members of this group are called " + nameOne + ", " + nameTwo + ", " + nameThree);
        // non-destructured version:
            System.out.println("OLD: The members of this group are called " +
                    ((GroupOfThree) obj).one().name() + ", "
                    + ((GroupOfThree) obj).two().name() + ", "
                    + ((GroupOfThree) obj).three().name());
        }
   }

   public static void switchMatch(Object obj){
        String result = switch (obj){
            case Team(var name, var members) when name.matches("myteam")-> "This is the best team";
            case Team(var name, var members) -> "TeamName: " + name;
            case Person(var name, var age) -> "PersonName: " + name;
            default -> "no name";
        };
       System.out.println(result);
   }


}
