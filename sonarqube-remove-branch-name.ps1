$params = "$env:SONARQUBE_SCANNER_PARAMS" -replace '"sonar.branch.name":"[\w,/,-]*"\,?'
Write-Host "##vso[task.setvariable variable=SONARQUBE_SCANNER_PARAMS]$params"
