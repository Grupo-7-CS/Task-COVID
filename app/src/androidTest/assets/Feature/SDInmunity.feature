Feature:
As 

a user

I want

to gain immunity to the damage caused by doing three things wrong after getting the second dose of the vaccine.

So that

  Scenario:Immunity at work
    Given The user has already taken the second dose
      And The user life is 100 points
     When user presses the button 'olvidarse la mascarilla'
     Then user life is still 100 points.
  
  Scenario:Immunity consumed
    Given The user has already taken the second dose
      And The user life is 80 points
      And The user resistence is 1
     When user presses the button 'Salir de fiesta' four times
     Then user life is reduced to 55 points.