import json

def writeToJSONFile(path, fileName, data):
    filePathNameWExt = './' + path + '/' + fileName + '.json'
    with open(filePathNameWExt, 'w') as fp:
        json.dump(data, fp)
writeToJSONFile('./','file-name',"https://live.euroleague.net/api/PlayByPlay?gamecode=307&seasoncode=E2020")
# './' represents the current directory so the directory save-file.py is in
# 'test' is my file name