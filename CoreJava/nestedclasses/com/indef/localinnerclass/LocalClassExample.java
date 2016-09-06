package com.indef.localinnerclass;

public class LocalClassExample {

	static String regularExpression = "[^0-9]";

	/*
	// You cannot declare an interface inside a block; interfaces are inherently static. 
	// For example, the following code excerpt does not compile because the interface 
	// HelloThere is defined inside the body of the method greetInEnglish:
	public void greetInEnglish() {
        interface HelloThere {
           public void greet();
        }
        class EnglishHelloThere implements HelloThere {
            public void greet() {
                System.out.println("Hello " + name);
            }
        }
        HelloThere myGreeting = new EnglishHelloThere();
        myGreeting.greet();
    }
    */
	
	/*
	// You cannot declare static initializers or member interfaces in a local class. 
	// The following code excerpt does not compile because the method EnglishGoodbye.sayGoodbye 
	// is declared static
	public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public static void sayGoodbye() {
                System.out.println("Bye bye");
            }
        }
        EnglishGoodbye.sayGoodbye();
    }
    */

	// A local class can have static members provided that they are constant variables. 
	// (A constant variable is a variable of primitive type or type String that is declared 
	// final and initialized with a compile-time constant expression. A compile-time 
	// constant expression is typically a string or an arithmetic expression that can
	// be evaluated at compile time. The following code excerpt compiles because the 
	// static member EnglishGoodbye.farewell is a constant variable.
	public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public static final String farewell = "Bye bye";
            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
    }
	
	public static void validatePhoneNumber(String phoneNumber1,
			String phoneNumber2) {

		final int numberLength = 10;

		// Valid in JDK 8 and later:
		// int numberLength = 10;
		
		
		class PhoneNumber {

			String formattedPhoneNumber = null;

			PhoneNumber(String phoneNumber) {
				// numberLength = 7; //number length is not effectively final so compiler will generate an error
				String currentNumber = phoneNumber.replaceAll(
						regularExpression, "");
				if (currentNumber.length() == numberLength)
					formattedPhoneNumber = currentNumber;
				else
					formattedPhoneNumber = null;
			}

			public String getNumber() {
				return formattedPhoneNumber;
			}

			/*
			// Valid in JDK 8 and later:
			public void printOriginalNumbers() {
				System.out.println("Original numbers are " + phoneNumber1 +
						" and " + phoneNumber2);
			}*/
		}

		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

		// Valid in JDK 8 and later:

		// myNumber1.printOriginalNumbers();

		if (myNumber1.getNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("First number is " + myNumber1.getNumber());
		
		if (myNumber2.getNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is " + myNumber2.getNumber());
	}

	public static void main(String... args) {
		validatePhoneNumber("123-456-7890", "456-7890");
	}
}