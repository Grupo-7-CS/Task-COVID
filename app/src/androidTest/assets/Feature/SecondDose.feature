Feature:
As 

a user

I want

to be able to presses second dose of the vaccine button and have my experience points increase by 150.

So that

  Scenario:The user is level one
    Given the user is level one with 0 experience points
     When user presses second dose button
     Then user's experience increases by 150 and goes up to level 1, remaining at level 2 with 50 experience points.
  
  Scenario:The user is level two
    Given the user is level two with 0 experience points
     When user presses second dose button
     Then user's experience increases by 150 and goes up to level 1, remaining at level 3 with 30 experience points.
  
  Scenario:The user is level four
    Given the user is level dour with 0 experience points
     When user presses second dose button
     Then user's experience increases by 150, but since 160 points are needed to go up to level 5, the user remains at level 4.
