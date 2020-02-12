cd /data-import
pattern="./"
folderpattern="/"
initpattern="data-import"
for D in `find . -type d`
do	
   folder=${D#$pattern}
   echo "Reading folder ${folder}"
   ls -1 ${folder}/*.json | sed 's/.json$//' | while read col; do 
        filename=${col#$folder}
        echo "Read folder ${folder#initpattern} and file .${filename}.json" 
	mongoimport --uri "mongodb://mongo:27017/test" --collection ${folder} --type json --drop --file ${col}.json --jsonArray
   done
done




