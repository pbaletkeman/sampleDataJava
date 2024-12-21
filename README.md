Programed and tested with Java 21

A simple Command Line program to generate some sample records.

#### Command Line options, everything is optional:
- file: sqlite file name to create and save data to, default to test.db
- buffy: number of Buffy records to create
- ancient: number of Ancient records to create
- beer: number of Beer records to create
- book: number of Book records to create
- person: number of Person records to create
- business: number of Business records to create
- commerce: number of Commerce records to create
- food: number of Food records to create

#### example command lines:
- java -jar sample-data.jar file:datafile.db book:10 person:10 business:10 commerce:10 food:1000

- java -jar sample-data.jar file:test.db buffy:1000 ancient:10 

- java -jar sample-data.jar buffy:10 ancient:10 beer:10 book:10 person:10 business:10 commerce:10 food:10
