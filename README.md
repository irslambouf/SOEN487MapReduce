# SOEN487MapReduce
SOEN 487 MapReduce assignment
Philippe Fisher 26424988
Using data from 1990
ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/by_year/1990.csv.gz

jar is in bin foler
output data is in bin folder under output.txt


1. get data 
ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/by_year/DATEHERE.csv.gz

2. mount data

-hadoop fs -mkdir /user/cloudera/temperature_data

-hadoop fs -copyFromLocal DATEHERE.csv /user/cloudera/temperature_data

3. Write eclipse program
4. Compile jar
Go in eclipse project /bin foler and run
jar cf NAMEOFJAR.jar ./*.class

5. Run hadoop job
hadoop jar NAMEOFJAR.jar NAMEOFJAVADRIVER /user/cloudera/temperature_data/DATEHERE.csv /user/cloudera/output

6. export to txt file
hadoop fs -cat /user/cloudera/output/part-r-00000 > output.txt
