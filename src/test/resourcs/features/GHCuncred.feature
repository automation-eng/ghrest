Feature: git-qa repo CRED

  @fuctional
  Scenario Outline: GH-qa repo CRED operations
    Given check the given "<reponame>" in github
    When "<reponame>" does not exist
    Then create the give "<reponame>"
    And Add file to "<reponame>"
    And modift the "<reponame>"
    And Delete the "<reponame>"
  

    Examples: 
      | reponame |
      | Rest5   |
     
