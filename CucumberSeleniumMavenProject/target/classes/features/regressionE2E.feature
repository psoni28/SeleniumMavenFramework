
@endtoend2
Feature: End to End product search
  
  Scenario: validate product search
  Given : user already login
  When : user enter product as "laptop"
  Then : all matching products should be displayed

