class Person {
  constructor(firstName, lastName, identification) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.idNumber = identification;
  }
  
  printPerson() {
      console.log(
          "Name: " + this.lastName + ", " + this.firstName 
          + "\nID: " + this.idNumber
      )
  }
}


class Student extends Person {
  /*	
  *   Class Constructor
  *   
  *   @param firstName - A string denoting the Person's first name.
  *   @param lastName - A string denoting the Person's last name.
  *   @param id - An integer denoting the Person's ID number.
  *   @param scores - An array of integers denoting the Person's test scores.
  */
  // Write your constructor here
  constructor( firstName,  lastName, id, scores)
  {
      super(firstName, lastName, id);
      this.scores = scores;
  }
  /*	
  *   Method Name: calculate
  *   @return A character denoting the grade.
  */
  // Write your method here
  calculate()
  {
      let sum = 0;
      let avg = 0;
      let grade = ' '; 
      for(let i =0; i < this.scores.length; i++)
      {
          sum = sum + parseInt(this.scores[i]);
      }

      if(this.scores.length != 0)
          avg = sum/this.scores.length;

      if(avg >=90 && avg <=100)
          grade = 'O';
      else if(avg >=80 && avg <90)
          grade = 'E';
      else if(avg >=70 && avg <80)
          grade = 'A';
      else if(avg >=55 && avg <70)
          grade = 'P';
      else if(avg >=40 && avg <55)
          grade = 'D';
      else if(avg <40)
          grade = 'T';

      return grade;
  }
}

let firstName = "Heraldo";
let lastName = "Memelli";
let id = 8135627;
let testScores = [100, 80];
// console.log("testScores : ",testScores);
// console.log("testScores.length : ",testScores.length);
let s = new Student(firstName, lastName, id, testScores)
s.printPerson()
// s.calculate()
console.log('Grade: ' + s.calculate())

  