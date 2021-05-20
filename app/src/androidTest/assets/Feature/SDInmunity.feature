Feature:
As 

a user

I want

to gain immunity to the damage caused by doing three things wrong (not stackable) after getting the second dose of the vaccine.

So that

  Scenario:Immunity at work
    Given The user has already taken the second dose, so he/she has 3 points of immunity.
      And The user life is 100 points
     When user presses the button 'olvidarse la mascarilla'
     Then The user still has 100 health points and 2 immunity points left.
  
  Scenario:Immunity consumed
    Given The user has already taken the second dose, so he/she has 3 points of immunity.
      And The user life is 80 points
      And The user resistence is 1
     When user presses the button 'Salir de fiesta' four times
     Then The user's life is reduced to 55 points and he is no longer immune.