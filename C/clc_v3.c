#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <math.h>

float binary(float float1,float float2 ,char operation);
float unary(float unFloat, char operator);
int leave();
char choices();

void main() {
   puts("Welcome to my Command-Line Calculator (CLC)\nDeveloper: Lucas Hoogstra");
   puts("Version: 3\nDate: Nov 26 2024\n");
   puts("Select one of the following items:\nB) - Binary Mathematical Operations, such as addition and subtraction.");
   puts("U) - Unary Mathematical Operations, such as square root, and log. \nA) - Advances Mathematical Operations, using variables, arrays.");
   puts("V) – Define variables and assign them values.\nE) - Exit");

   //initializing variables
   char choice;
   char op;
   int count = 0;
   float answer = 0;
   char num1[50] = {0};
   char num2[50] = {0};
   char A[50] = {0};
   char B[50] = {0};
   char C[50] = {0};
   char D[50] = {0};
   char E[50] = {0};

   //starts the loop that exits when user inputs  e
   while(choice != 'E' & choice != 'e'){
      choice = choices();
      answer = 0;
      //resets number arrays to 0
      for(int i=0; i< sizeof(num1); i++){
                  num1[i] = 0;
               }
      for(int i=0; i< sizeof(num2); i++){
                  num2[i] = 0;
               }
      
      //starts case for what type of equation
      switch(toupper(choice)){ 
         case 'B':
            puts("Enter your first number:");
            scanf(" %s", &num1);


            //verifys number and confirms number is valid
            for(int i=0; i< sizeof(num1); i++){
               if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-'){
                  count++;
               }
            }
            while (count !=0){
               for(int i=0; i< sizeof(num1); i++){
                  num1[i] = 0;
               }
               puts("Enter a valid number:");
               scanf(" %s", &num1);
               count = 0;
               for(int i=0; i< sizeof(num1); i++){
                  if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                     count++;
                  }
               }
            }
            //makes a float to do calculations
            float number1 = atof(num1);

            //checks to confirm operator is valid
            puts("Enter an operator:");
            scanf(" %c", &op);

            while(op != '+' & op != '-'  & op != '*' & op != '/' & op != '%' & toupper(op) != 'P' & toupper(op) != 'X' & toupper(op) != 'I' ){
               printf("%s","Enter a valid operator:\n");
               scanf(" %c" , &op);
            };

            // checks to confirm second number is valid
            puts("Enter your second number:");
            scanf(" %s", &num2);

            for(int i=0; i< sizeof(num2); i++){
               if(isdigit(num2[i])==0 & num2[i] != '.' & num2[i]!= 0 & num2[0] != '-'){
                  count++;
               }
            }
            while (count !=0){
               for(int i=0; i< sizeof(num1); i++){
                  num2[i] = 0;
               }
               puts("Enter a valid number:");
               scanf(" %s", &num2);
               count = 0;
               for(int i=0; i< sizeof(num2); i++){
                  if(isdigit(num2[i])==0 & num2[i] != '.' & num2[i]!= 0 & num2[0] != '-' ){
                     count++;
                  }
               }
            }
            //makes a float to do calculations
            float number2 = atof(num2);

            //calls function
            answer = binary(number1,number2,op);

            printf("The answer is %g\n", answer);
            choice = choices();
            break;
         case 'U':
            puts("Enter your number:");
            scanf(" %s", &num1);

            //number validation
            for(int i=0; i< sizeof(num1); i++){
               if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-'){
                  count++;
               }
            }
            while (count !=0){
               for(int i=0; i< sizeof(num1); i++){
                  num1[i] = 0;
               }
               puts("Enter a valid number:");
               scanf(" %s", &num1);
               count = 0;
               for(int i=0; i< sizeof(num1); i++){
                  if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                     count++;
                  }
               }
            }
            number1 = atof(num1);
            puts("Enter an operator:");
            scanf(" %c", &op);

            // operator validation
            while(op != 'S' & op != 'L'  & op != 'E' & op != 'C' & op != 'F'){
               printf("%s","Enter a valid operator:\n");
               scanf(" %c" , &op);
            };
            answer = unary(number1, op);
            printf("The answer is %g\n", answer);
            choice = choices();
            break;
         case 'V':
            puts( "Input a variable A, B ,C, D, E:");
            scanf(" %c", &op);
            //makes sure on of the letters avalable is chosen
            while(toupper(op) != 'A' & toupper(op) != 'B'  & toupper(op) != 'C' & toupper(op) != 'D' & toupper(op) != 'E'){
               printf("%s","Enter a valid option:\n");
               scanf(" %c" , &op);
            };
            puts("Enter your number:");
            scanf(" %s", &num1);

            //number validation
            for(int i=0; i< sizeof(num1); i++){
               if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-'){
                  count++;
               }
            }
            while (count !=0){
               for(int i=0; i< sizeof(num1); i++){
                  num1[i] = 0;
               }
               puts("Enter a valid number:");
               scanf(" %s", &num1);
               count = 0;
               for(int i=0; i< sizeof(num1); i++){
                  if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                     count++;
                  }
               }
            }
            //turns the letter into the number for later
            switch(toupper(op)){
               case 'A':
                  for(int i=0; i<sizeof(num1); i++){
                     A[i] = num1[i];
                  }
                  break;
               case 'B':
                  for(int i=0; i<sizeof(num1); i++){
                     B[i] = num1[i];
                  }
                  break;
               case 'C':
                  for(int i=0; i<sizeof(num1); i++){
                     C[i] = num1[i];
                  }
                  break;
               case 'D':
                  for(int i=0; i<sizeof(num1); i++){
                     D[i] = num1[i];
                  }
                  break;
               case 'E':
                  for(int i=0; i<sizeof(num1); i++){
                     E[i] = num1[i];
                  }
                  break;
            }
            choice = choices();
            for(int i = 0; i<sizeof(num1); i++){
               num1[i]=0;
            }
            break;
         case 'A':
            puts( "Enter B, U, E:");
            scanf(" %c", &choice);
            while(toupper(choice) != 'B' & toupper(choice) != 'U'  & toupper(choice) != 'E' ){
               printf("%s","Enter a valid option:\n");
               scanf(" %c" , &choice);
            };
            switch(toupper(choice)){
               case 'B':
                  puts("Enter your first number:");
                  scanf(" %s", &num1);
                  //if letter is chosen turn the first number into the variable number
                  if(toupper(num1[0]) == 'A' |toupper(num1[0]) == 'B' |toupper(num1[0]) == 'C' |toupper(num1[0])== 'D' |toupper(num1[0]) == 'E' ){
                     switch (toupper(num1[0])){
                        case 'A':
                           for(int i=0; i<sizeof(num1); i++){
                              num1[i] = A[i];
                           }
                           break;
                        case 'B':
                           for(int i=0; i<sizeof(num1); i++){
                              num1[i] = B[i];
                           }
                           break;
                        case 'C':
                           for(int i=0; i<sizeof(num1); i++){
                              num1[i] = C[i];
                           }
                           break;
                        case 'D':
                           for(int i=0; i<sizeof(num1); i++){
                              num1[i] = D[i];
                           }
                           break;
                        case 'E':
                           for(int i=0; i<sizeof(num1); i++){
                              num1[i] = E[i];
                           }
                           break;
                     }
                  }

                  //number validation
                  for(int i=0; i< sizeof(num1); i++){
                     if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-'){
                        count++;
                     }
                  }

                  while (count !=0){
                     for(int i=0; i< sizeof(num1); i++){
                        num1[i] = 0;
                     }

                     puts("Enter a valid number:");
                     scanf(" %s", &num1);
                     count = 0;
                     for(int i=0; i< sizeof(num1); i++){
                        if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                           count++;
                        }
                     }  
                  }

                  float number1 = atof(num1);

                  puts("Enter an operator:");
                  scanf(" %c", &op);
                  //operator validation
                  while(op != '+' & op != '-'  & op != '*' & op != '/' & op != '%' & toupper(op) != 'P' & toupper(op) != 'X' & toupper(op) != 'I' ){
                     printf("%s","Enter a valid operator:\n");
                     scanf(" %c" , &op);
                  };
                  //number validation
                  puts("Enter your second number:");
                  scanf(" %s", &num2);
                  if(toupper(num2[0]) == 'A' |toupper(num2[0]) == 'B' |toupper(num2[0]) == 'C' |toupper(num2[0])== 'D' |toupper(num2[0]) == 'E' ){
                     switch (toupper(num2[0])){
                        case 'A':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = A[i];
                           }
                           break;
                        case 'B':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = B[i];
                           }
                           break;
                        case 'C':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = C[i];
                           }
                           break;
                        case 'D':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = D[i];
                           }
                           break;
                        case 'E':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = E[i];
                           }
                           break;
                     }
                  }
                  for(int i=0; i< sizeof(num2); i++){
                     if(isdigit(num2[i])==0 & num2[i] != '.' & num2[i]!= 0 & num2[0] != '-'){
                        count++;
                     }
                  }

                  while (count !=0){
                     for(int i=0; i< sizeof(num1); i++){
                        num2[i] = 0;
                     }

                     puts("Enter a valid number:");
                     scanf(" %s", &num2);
                     count = 0;
                     for(int i=0; i< sizeof(num2); i++){
                        if(isdigit(num2[i])==0 & num2[i] != '.' & num2[i]!= 0 & num2[0] != '-' ){
                           count++;
                        }
                     
                     }
                  }
                  float number2 = atof(num2);
                  //cases for each operation
                  switch(toupper(op)){
                     case '+':
                        answer = number1 + number2;
                        break;
                     case '-':
                        answer = number1 - number2;
                        break;
                     case '*':
                        answer = number1 * number2;
                        break;
                     case '/':
                        // number validation
                        while( number2 == 0 | count != 0){
                           for(int i=0; i< sizeof(num1); i++){
                              num2[i] = 0;
                           }
                           puts("Your second number must not be 0, Please enter a valid interger:");
                           scanf(" %s", &num2);
                           count = 0;
                           for(int i=0; i< sizeof(num2); i++){
                              if(isdigit(num2[i])==0 & num2[i] != '.' & num2[i]!= 0 & num2[0] != '-' ){
                                 count++;
                              }
                           }
                           float number2 = atof(num2);
                        }
                        answer = number1 / number2;
                        break;
                     case '%':
                        int intnum1 = atof(num1);
                        int intnum2 = atof(num2);
                        //number validation
                        while(number1 / intnum1 != 1 & count != 0){
                           for(int i=0; i< sizeof(num1); i++){
                              num1[i] = 0;
                           }
                           puts("Your first number must be an interger, Please enter a valid interger:");
                           scanf(" %s", &num1);
                           count = 0;
                           for(int i=0; i< sizeof(num1); i++){
                              if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                                 count++;
                              }
                           }
                           intnum1 = atof(num1);
                        }
                        while(number2 / intnum2 != 1 & count != 0){
                           for(int i=0; i< sizeof(num1); i++){
                              num2[i] = 0;
                           }
                           puts("Your second number must not be 0, Please enter a valid interger:");
                           scanf(" %s", &num2);
                           count = 0;
                           for(int i=0; i< sizeof(num2); i++){
                              if(isdigit(num2[i])==0 & num2[i] != '.' & num2[i]!= 0 & num2[0] != '-' ){
                                 count++;
                              }
                           }
                           intnum2 = atof(num2);
                        }
                        answer = intnum1 % intnum2;
                        break;
                     case 'P':
                        answer = powf(number1, number2);
                        break;
                     case 'X':
                        if(number1 < number2){
                           answer = number2;
                        }
                        else{
                           answer = number1;
                        }
                        break;
                     case 'I':
                        if(number1 > number2){
                           answer = number2;
                        }
                        else{
                           answer = number1;
                        }
                        break;
                  }
                  printf("The answer is %g\n", answer);
                  choice = choices();
                  break;
               case 'U':
                  puts("Enter your number:");
                  scanf(" %s", &num1);
                  //number validation with variables
                  if(toupper(num2[0]) == 'A' |toupper(num2[0]) == 'B' |toupper(num2[0]) == 'C' |toupper(num2[0])== 'D' |toupper(num2[0]) == 'E' ){
                     switch (toupper(num2[0])){
                        case 'A':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = A[i];
                           }
                           break;
                        case 'B':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = B[i];
                           }
                           break;
                        case 'C':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = C[i];
                           }
                           break;
                        case 'D':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = D[i];
                           }
                           break;
                        case 'E':
                           for(int i=0; i<sizeof(num2); i++){
                              num2[i] = E[i];
                           }
                           break;
                     }
                  }
                  for(int i=0; i< sizeof(num1); i++){
                     if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-'){
                        count++;
                     }
                  }
                  while (count !=0){
                     for(int i=0; i< sizeof(num1); i++){
                        num1[i] = 0;
                     }
                     puts("Enter a valid number:");
                     scanf(" %s", &num1);
                     count = 0;
                     for(int i=0; i< sizeof(num1); i++){
                        if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                           count++;
                        }
                     }
                  }
                  number1 = atof(num1);
                  puts("Enter an operator:");
                  scanf(" %c", &op);
                  //checks for valid operation
                  while(toupper(op) != 'S' & toupper(op) != 'L'  & toupper(op) != 'E' & toupper(op) != 'C' & toupper(op) != 'F'){
                     printf("%s","Enter a valid operator:\n");
                     scanf(" %c" , &op);
                  };
                  switch(toupper(op)){
                     case 'S':
                        while( number1 < 0 | count != 0){
                           for(int i=0; i< sizeof(num1); i++){
                              num1[i] = 0;
                           }
                           puts("This number cant be less than 0, Please enter another number:");
                           scanf(" %s", &num1);
                           count = 0;
                           for(int i=0; i< sizeof(num1); i++){
                              if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                                 count++;
                              }
                                    
                           }
                           number1 = atof(num1);
                        }
                        answer = sqrtf(number1);
                        break;
                     case 'L':
                        while( number1 <= 0 | count != 0){
                           for(int i=0; i< sizeof(num1); i++){
                              num1[i] = 0;
                           }
                           puts("This number cant be 0 or less, Please enter another number:");
                           scanf(" %s", &num1);
                           count = 0;
                           for(int i=0; i< sizeof(num1); i++){
                              if(isdigit(num1[i])==0 & num1[i] != '.' & num1[i]!= 0 & num1[0] != '-' ){
                                 count++;
                              }
                                    
                           }
                           number1 = atof(num1);
                        }
                        answer = log10(number1);
                        break;
                     case 'E':
                        answer = expf(number1);
                        break;
                     case 'C':
                        answer = ceil(number1);
                        break;
                     case 'F':
                        answer = floorf(number1);
                        break;
                  }
                  printf("The answer is %g\n", answer);
                  choice = choices();
                  break;
               case 'E':
                  leave();
                  break;
            }
            break;
         case 'E':
            leave();
            break;
      }
   }
}

float binary(float float1, float float2 ,char operation){
   float output = 0;
   int counter = 0;
   char array1[50] = {0};
   char array2[50] = {0};
   //cases for each operation
   switch(toupper(operation)){
      case '+':
         output = float1 + float2;
         break;
      case '-':
         output = float1 - float2;
         break;
      case '*':
         output = float1 * float2;
         break;
      case '/':
         //confirms second number is not 0
         while( float2 == 0 | counter != 0){
            for(int i=0; i< sizeof(array2); i++){
               array2[i] = 0;
            }
            puts("Your second number must not be 0, Please enter a valid interger:");
            scanf(" %s", &array2);
            counter = 0;
            for(int i=0; i< sizeof(array2); i++){
               if(isdigit(array2[i])==0 & array2[i] != '.' & array2[i]!= 0 & array2[0] != '-' ){
                  counter++;
               }
            }
             float number2 = atof(array2);
         }       
         output = float1 / float2;
         break;
      case '%':
         //creates ints for each number
         int intnum1 = atof(array1);
         int intnum2 = atof(array2);
         //confirms numbers inputed are ints
         while(float1 / intnum1 != 1 & counter != 0){
            for(int i=0; i< sizeof(array1); i++){
               array1[i] = 0;
            }

            puts("Your first number must be an interger, Please enter a valid interger:");
            scanf(" %s", &array1);
            counter = 0;
            for(int i=0; i< sizeof(array1); i++){
              if(isdigit(array1[i])==0 & array1[i] != '.' & array1[i]!= 0 & array1[0] != '-' ){
              counter++;
               }
            }
            intnum1 = atof(array1);
         }
         // checks if second number is an int and isnt 0
         while(float2 / intnum2 != 1 & counter != 0){
            for(int i=0; i< sizeof(array1); i++){
               array2[i] = 0;
            }
            puts("Your second number must not be 0, Please enter a valid interger:");
            scanf(" %s", &array2);
            counter = 0;
            for(int i=0; i< sizeof(array2); i++){
               if(isdigit(array2[i])==0 & array2[i] != '.' & array2[i]!= 0 & array2[0] != '-' ){
                  counter++;
               }
            }
            intnum2 = atof(array2);
         }
         output = intnum1 % intnum2;
         break;
      case 'P':
         output = powf(float1, float2);
         break;
      case 'X':
         if(float1 < float2){
            output = float2;
         }
         else{
            output = float1;
         }
         break;
      case 'I':
         if(float1 > float2){
            output = float2;
         }
         else{
            output = float1;
         }
         break;
            }
   return output;
}
float unary(float unFloat, char operator){
   float finalFloat = 0;
   int counts = 0;
   char unArray[50]= {0};
   switch(toupper(operator)){
      case 'S':
         while( unFloat < 0 | counts != 0){
            for(int i=0; i< sizeof(unArray); i++){
               unArray[i] = 0;
            }
            puts("This number cant be less than 0, Please enter another number:");
            scanf(" %s", &unArray);
            counts = 0;
            for(int i=0; i< sizeof(unArray); i++){
               if(isdigit(unArray[i])==0 & unArray[i] != '.' & unArray[i]!= 0 & unArray[0] != '-' ){
                  counts++;
               }
                     
            }
            unFloat = atof(unArray);
         }
         finalFloat = sqrtf(unFloat);
         break;
      case 'L':
         while( unFloat <= 0 | counts != 0){
               for(int i=0; i< sizeof(unArray); i++){
                  unArray[i] = 0;
               }
               puts("This number cant be 0 or less, Please enter another number:");
               scanf(" %s", &unArray);
               counts = 0;
               for(int i=0; i< sizeof(unArray); i++){
                  if(isdigit(unArray[i])==0 & unArray[i] != '.' & unArray[i]!= 0 & unArray[0] != '-' ){
                     counts++;
                  }
                        
               }
               unFloat = atof(unArray);
            }
         finalFloat = log10(unFloat);
         break;
      case 'E':
         finalFloat = expf(unFloat);
         break;
      case 'C':
         finalFloat = ceil(unFloat);
         break;
      case 'F':
         finalFloat = floorf(unFloat);
         break;
            }
   return finalFloat;
}
int leave(){
   //exit message
   puts("Thank you for using this calculator.");
}

char choices(){
   char  thingToDo;
   puts("Choose an option B , U , A , V , E:");
   scanf(" %c", &thingToDo);
   thingToDo = toupper(thingToDo);
   printf("%c", thingToDo);
   while(thingToDo != 'E' & thingToDo != 'A'& thingToDo != 'B'& thingToDo != 'V'& thingToDo != 'U'){
      puts("Choose a valid option B, U, A, V, E");
      scanf(" %c", &thingToDo);
      thingToDo = toupper(thingToDo);
   }
   return thingToDo;
}