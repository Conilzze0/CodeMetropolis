# CodeMetropolis
## Introduction  
This documentation is designed to help new developers and team members to understand how
the project is developed and maintained.

## Table of Contents
1. [Getting Started](#getting-started)
   1. [Prerequisites](#prerequisites)
   2. [Install the Codebase](#install-the-codebase)
2. [Development Process](#development-process)
   1. [Merge to Feature Process](#merge-to-feature-process)
   2. [Merge to Develop Process](#merge-to-develop-process)
   3. [Pull Request](#pull-request)
   4. [Branch Types](#branch-types)
   5. [Branching Strategy](#branching-strategy)
3. [Quality Gates](#quality-gates)
   1. [Testing](#testing)
   2. [CheckStyle](#checkstyle)
   3. [Pre-commit Hook](#pre-commit-hook)
   4. [SonarQube](#sonarqube)
   5. [JaCoCo](#jacoco)
4. [CI/CD](#cicd)
   1. [Pipeline Steps](#pipeline-steps)

## Getting Started
### Prerequisites
* Download and install Java 1.8 version: https://www.openlogic.com/openjdk-downloads
* Download and install Maven 3.8.3 or newer: https://maven.apache.org/download.cgi
* Download and install Git: https://git-scm.com/downloads
* Download and install Python: https://www.python.org/downloads/
* (Optional) Download and install any Java IDE (e.g., IntelliJ, Eclipse, etc.) 

### Install the Codebase
1. Clone the repository into a directory of your choice:
   * ```git clone https://github.com/codemetropolis/CodeMetropolis.git```
2. Checkout the develop branch:
   * ```git checkout develop```
3. Navigate to the 'sources' folder:
   * ```cd sources```
4. Install the code:
   * ```mvn clean install -DskipTests```

## Development Process
### Merge to Develop Process
![merge_to_develop](docs/merge_to_develop.svg)

### Pull Request
The developer must create a pull request in order to merge back the new code
into the target branch.
1. Create a pull request on the [CodeMetropolis GitHub page](https://github.com/Conilzze0/CodeMetropolis)
2. Set the branches accordingly, select the branch where you want to merge from,
and the target branch you want to merge into
3. Fill in the description with the following:
   * Detailed information about the problem or the added new function
   * List of dependencies if there are any
   * The possible effects on another function which is caused by this code change
   * List of reviewers
4. Set up at least `1` reviewer who can review the code change
5. Submit the pull request
6. The reviewer has to review the code, can add comments, make suggestions
7. The pull request can be merged if:
   * All comments are addressed and resolved
   * The reviewers approved the pull request
   * All checks have passed
8. Use squash and merge

### Branch Types
* `master`  
    The main branch, contains the complete production-ready code.
* `develop`  
    Development branch, continuous development is happening on this branch. Developers
    can merge their feature branches into this branch.
* `feature`  
    These branches contain new function and test implementations for each task.
* `implementation`  
    The code and unit test implementation of the new function.
* `test`  
    Contains functional tests that make sure that the new functionality works as expected.

### Branching Strategy
![branching strategy](docs/branching_strategy.svg)

## Quality Gates
### Testing
This project contains **JUnit** tests to ensure the correctness of the codebase and **functional Python tests**
to validate end-to-end scenarios and ensure that the application works as expected.
* The **JUnit** tests can be found in the `src/test` directory of each tool and can be
  executed by running the following command:  
  ```mvn test```
* The **functional Python testing** framework can be found in the `sources/test` directory.  
To use this framework, execute the `CodeMetropolis Tester Interface.py` script, which
opens a graphical user interface where the developer can run the functional tests.

### CheckStyle
The project contains CheckStyle integration to make sure that high quality code
is created during implementation. 
* These code quality standards are described in `rules/checkstyle_rules.xml` file
* To check that the code satisfies these standards, you can run the following:  
  ```mvn checkstyle:check```

### Pre-commit Hook
There is a predefined pre-commit git hook available for the project. If installed, this script
will execute before each commit action, and runs a code quality check ONLY on the modified java files.  
* To install this pre-commit hook, simply copy the `pre-commit` (without file extension) file from the rules
directory to the local git repository's `.git/hooks/` directory.

### SonarQube
CodeMetropolis also has a SonarQube integrated to improve the quality of the codebase.  
SonarQube report generation is triggered when a pull request is created.
* SonarCloud has been configured to visualize these details, which can be accessed here:
https://sonarcloud.io/summary/overall?id=Conilzze0_CodeMetropolis

### JaCoCo
JaCoCo is also available to help developers determine how much the code is covered with automated tests.  
* To use this tool, run the following command:
  `mvn clean verify`
* After the execution, a report is generated under the `sources/report-aggregate/target/site/jacoco-aggregate` directory
* To view the report, start a web server and open the `index.html`
  * In IntelliJ, you can right-click on the `index.html` file -> Open In -> Browser and select your favourite browser

## CI/CD
This project is equipped with Continuous Integration and Continuous Deployment pipeline to ensure
the quality, reliability and maintainability of the codebase.

### Pipeline Steps
1. **Automated Maven Build**
   * The CI/CD pipeline begins with an automated Maven build triggered by GitHub Actions
   whenever new code is pushed or a pull request is created.
   * During the build process, JUnit tests are also executed. 
2. **Functional Python Tests**
   * The pipeline includes functional Python tests to ensure overall functionality.
3. **Checkstyle**
   * During the Maven build the Checkstyle plugin is also triggered to make sure that high quality code
     is created during implementation.
   * The job is configured in a way that only the modified `.java` files are checked.
4. **JacCoCo Code Coverage**
   * Jacoco performs code coverage analysis to determine the code test coverage.
   * The generated report is sent to SonarQube.
5. **SonarQube**
   * Provides advanced code analysis, identifies code smells, bugs and security vulnerabilities.
   * SonarQube also calculates technical dept, helping us prioritize improvements and maintain a healthy codebase.
   * The tool is connected to SonarCloud to visualize the reports generated by SonarQube.
   * Conditions are defined for both **New and Overall code** on [SonarCloud](https://sonarcloud.io/project/overview?id=Conilzze0_CodeMetropolis)
        

The reports generated by the tools listed above are attached to each pull request.
