#include <stdio.h>
#include <ctype.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
// defines students and the components in student
typedef struct{
    char name[50];
    float weight;
    float maxPoints;
    float points; 
} comp;

typedef struct{
    char name[50];
    int numComponents;
    float finalGrade;
    char letterGrade[2];
    comp *workPlease;
} student;

int assinger(student **pointer, int option);
float getNum();
int getIntNum();
void finalLetter(student **st, int numStudent, int num);
int sort(student **point, int numOStudent);
void findStudent(student **point, int numOStudent);

int main(void){
    int choice = 0;
    student s1;
    student* ptr = &s1;
    int sNum=0;
    int counter=0;
    // starts loop that only ends when 5 is entered
    while(choice !=5){
    // displays options
    puts("\t\tGrade Calculator");
    puts("1. Single Student");
    puts("2. Multiple Students");
    puts("3. Sorting Students");
    puts("4. Finding Students");
    puts("5. Exits the program");   
    printf("%s", "Enter 1, 2, 3, 4 or 5: ");
    choice = getIntNum();

        if (choice == 1){
            puts("Enter students name:");
            scanf(" %[^\n]%*c", s1.name);
            puts("Enter number of components:");
            s1.numComponents = getIntNum();
            while(s1.numComponents <= 0){
                printf("%s", "That is too few components\nTry Again: ");
                s1.numComponents = getIntNum();
            }
            s1.workPlease = (comp*)malloc(sizeof(comp) * ((unsigned long)s1.numComponents));
            sNum=assinger(&ptr, choice);
            free(s1.workPlease);
        }
        else if (choice == 2){
            puts("Enter number of components:");
            s1.numComponents = getIntNum();
            while(s1.numComponents <= 0){
                printf("%s", "That is too few components\nTry Again: ");
                s1.numComponents = getIntNum();
            }     
            sNum=assinger(&ptr, choice);
        }
        else if (choice == 3){
            sort(&ptr, sNum);
            counter++;
        }
        else if (choice == 4){
            findStudent(&ptr, sNum);
        }
        else if(choice == 5){
            continue;
        }
        else{
            puts("No option found, Please try again.");
        }
    }
    puts("Thank you for using this calculator");
    free(ptr);
}
//assigns numbers to the students
int assinger(student **s, int option){
    int studentNum = 1; 
    if (option == 2){
        int components = (*s)->numComponents;
        (*s) = malloc( sizeof(student) * (studentNum));
        (*s)->workPlease = malloc(sizeof(comp) * (components));
        (*s)->numComponents = components;

    }
    int totalWeight = 0;
    while (totalWeight != 100){
        for(int i =1; i<=(*s)->numComponents; i++){
            printf("Component %d\n\tName: ", i);
            char temp[50];
            scanf(" %[^\n]%*c", temp);
            strcpy((((*s)+studentNum-1)->workPlease+i-1)->name, temp);
            printf("%s", "\tWeight: ");
            ((((*s)+studentNum-1)->workPlease+i-1)->weight) = getNum();
            while(((*s)->workPlease+i-1)->weight > 100 || ((*s)->workPlease+i-1)->weight < 1){
                printf("%s", "\tThat is not a valid weight\n\tEnter a new Weight: ");
                ((*s)->workPlease+i-1)->weight = getNum();
            }

            totalWeight += ((*s)->workPlease+i-1)->weight;
            printf("%s", "\tMax Points: ");
            ((*s)->workPlease+i-1)->maxPoints = getNum();
            while(((*s)->workPlease+i-1)->maxPoints < 1){
                printf("%s", "\tThat is not a valid max\n\tEnter a new max: ");
                ((*s)->workPlease+i-1)->maxPoints = getNum();
            }
            if(option == 1){
                printf("%s", "\tScore: ");
                ((*s)->workPlease+i-1)->points = getNum();
                while(((*s)->workPlease+i-1)->points > ((*s)->workPlease+i-1)->maxPoints){
                    printf("%s", "\tThat is not a valid score\n\tEnter a new score: ");
                    ((*s)->workPlease+i-1)->points = getNum();
                }
            }
        }
        if (totalWeight != 100){
            puts("Total weight is not 100. Please re-enter the component details;");
            totalWeight=0;
        }
    }
    if(option==1){
        finalLetter((s), 0, 1);
    }
    if(option == 2){
        while(strcmp(((*s)+studentNum-1)->name,"DONE")!= 0){
            if (studentNum>1){
                (*s) = (student*)realloc((*s), sizeof(student) * ((unsigned long)studentNum));
                ((*s)+studentNum-1)->workPlease = ((*s)+studentNum-2)->workPlease;
            }
            puts("Enter students name (Or DONE to end):");
            scanf(" %[^\n]%*c", ((*s)+studentNum-1)->name);
            if(strcmp(((*s)+studentNum-1)->name,"DONE")== 0){
                break;
            }
            else{
                for(int i =1; i<=(*s)->numComponents; i++){
                    printf("\tScore for %s: ", (((*s)+studentNum-1)->workPlease+i-1)->name);
                    (((*s)+studentNum-1)->workPlease+i-1)->points = getNum();
                    while((((*s)+studentNum-1)->workPlease+i-1)->points > (((*s)+studentNum-1)->workPlease+i-1)->maxPoints){
                        printf("%s", "\tThat is not a valid score\n\tEnter a new score: ");
                        (((*s)+studentNum-1)->workPlease+i-1)->points = getNum();
                    }
                }
                finalLetter((s),studentNum-1,2);
            }
            studentNum++;
        } 
        float avg=0;
        float class[studentNum-1];
        for(int j=0; j<studentNum-1; j++){
            avg += ((*s)+j)->finalGrade;
            class[j] = ((*s)+j)->finalGrade;
            printf("Student name: %s\nGrade: %g%\nLetter Grade: %s\n", ((*s)+j)->name, ((*s)+j)->finalGrade, ((*s)+j)->letterGrade);
        }
        float temp;
        for(int i=0; i<studentNum-1; i++){
            for(int j=0; j<studentNum-1; j++){
                if (class[i] > class[j] ){
                    temp = class[i];
                    class[i] = class[j];
                    class[j] = temp;
                }
            }
        }
        float median = 0;
        if ((studentNum-1)%2==1){
            median = class[(studentNum-1)/2];
        }
        else{
            median = ((class[(studentNum-1)/2]+class[(studentNum-3)/2])/2);
        }

        printf("Maximum: %g%\nClass average: %g%\nMedian: %g%\n",class[0], avg/(studentNum-1),median);
    }
    return(studentNum-1);
}
void finalLetter(student **st, int numStudents, int num){
    for(int j =numStudents; j<=numStudents; j++){
        float grade = 0;
        for(int i =1; i<=(*st)->numComponents; i++){
            grade += (float)((((*st)+j)->workPlease+i-1)->points)/(float)((((*st)+j)->workPlease+i-1)->maxPoints)*(float)((((*st)+j)->workPlease+i-1)->weight);
        }
        ((*st)+j)->finalGrade = grade;
        if (roundf(((*st)+j)->finalGrade)>=90){
            strcpy(((*st)+j)->letterGrade, "A+");
        }
        else if (roundf(((*st)+j)->finalGrade)&&(roundf(((*st)+j)->finalGrade)>=85)){
            strcpy(((*st)+j)->letterGrade, "A");
        }
        else if ((roundf(((*st)+j)->finalGrade)<=84)&&(roundf(((*st)+j)->finalGrade)>=80)){
            strcpy(((*st)+j)->letterGrade, "A-");
        }
        else if ((roundf(((*st)+j)->finalGrade)<=79)&&(roundf(((*st)+j)->finalGrade)>=75)){
            strcpy(((*st)+j)->letterGrade, "B+");
        }
        else if ((roundf(((*st)+j)->finalGrade)<=74)&&(roundf(((*st)+j)->finalGrade)>=70)){
            strcpy(((*st)+j)->letterGrade, "B");
        }
        else if ((roundf(((*st)+j)->finalGrade)<=69)&&(roundf(((*st)+j)->finalGrade)>=65)){
            strcpy(((*st)+j)->letterGrade, "C+");
        }
        else if ((roundf(((*st)+j)->finalGrade)<=64)&&(roundf(((*st)+j)->finalGrade)>=60)){
            strcpy(((*st)+j)->letterGrade, "C");
        }
        else if ((roundf(((*st)+j)->finalGrade)<=59)&&(roundf(((*st)+j)->finalGrade)>=50)){
            strcpy(((*st)+j)->letterGrade, "D");
        }
            
        else{
            strcpy(((*st)+j)->letterGrade, "F");
        }
        if (num==1){
            printf("Student name: %s\nGrade: %g%\nLetter Grade: %s\n", ((*st)+j)->name, ((*st)+j)->finalGrade, ((*st)+j)->letterGrade);
        }
    }
}
int sort(student **point, int numOStudent){
    if(numOStudent == 0){
      puts("No Students Found");
      return 0;  
    }
    student tempS;
    student* ptrTemp = &tempS;
    student **tempo = &ptrTemp;
    //loop for sorting 
    for(int i=0; i<=numOStudent-1; i++){
        for(int j=0; j<=numOStudent-1; j++){
            if (((*point)+i)->finalGrade > ((*point)+j)->finalGrade ){
                memcpy((*tempo), ((*point)+i), sizeof(student));
                memcpy(((*point)+i), ((*point)+j), sizeof(student));
                memcpy(((*point+j)), (*tempo), sizeof(student));
            }
        }
    }   
    for(int i=0; i<=numOStudent-1; i++){
        printf("%d. %s %g (%s)\n", i+1, (*point+i)->name,(*point+i)->finalGrade,(*point+i)->letterGrade);
    }
}
//finds student by name
void findStudent(student **point, int numOStudent){
    char nameToFind[50];
    int count =0;
    printf("%s", "Enter Students Name: ");
    scanf(" %[^\n]%*c", nameToFind);
    for(int i=0; i<=numOStudent-1; i++){
        if(strcmp(nameToFind, ((*point)+i)->name) == 0){
            printf("%d. %s %g% (%s)\n", i+1, (*point+i)->name,(*point+i)->finalGrade,(*point+i)->letterGrade);
            count++;
        }
    }
    if(count==0){
        puts("Student does not exsist.");
    }
}
// number verification 
float getNum(){
    float num = 0;
    int works;
    works = scanf(" %f", &num);
    while (works != 1 || num<0){
        while (getchar() != '\n');
        printf("%s","Invalid number, Please enter another: ");
        works = scanf(" %f", &num);
    }
    return num;
    
}
int getIntNum(){
    int num = 0;
    int works;
    works = scanf(" %d", &num);
    while (works != 1 || num<0){
        while (getchar() != '\n');
        printf("%s","Invalid number, Please enter another: ");
        works = scanf(" %d", &num);
    }
    return num;
    
}
