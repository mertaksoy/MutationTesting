# Mutation Testing - Pitest
Java mutation testing using [Pitest](https://pitest.org/)

## Test
Following command will output a html report to target/pit-reports/
```
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```
After executing command report could be found in `target/pit-reports/index.html`

![image info](./src/test/resources/pit-report.jpg)