Feature: test first attempt


  Scenario Outline: scenario1

    Given login page
    When we enter "<username>" and "<password>"
    Then login happens

    Examples:
      | username    | password |
      | 09393934673 | mah94mah |
