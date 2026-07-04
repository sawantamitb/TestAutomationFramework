$cp = Get-Content -Raw "cp.txt"
$full = "target\test-classes;target\classes;" + $cp
Write-Host "Running java with classpath length:" ($full.Length)
java -cp $full com.ui.test.LoginTest
