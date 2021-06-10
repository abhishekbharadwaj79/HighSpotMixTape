# Overview #

This project does the following:

1. Ingest an input JSON file which we will provide, mixtape.json.
2. Ingest a changes file changes.json which includes multiple changes in it.
3. Produce output.json which has the same structure as the mixtape.jsoninput.

# Features #

Following are the features applied on mixtape.json

1. Add a new playlist; the playlist contains at least one song
2. Remove a playlist.
3. Add an existing song to an existing playlist


# Environment #
1. MacOS
2. Java >= 1.11
3. Maven = 3.8.0

# How to Run #

## Go to the project folder and execute the following command in terminal ##

> mvn exec:java -Dexec.mainClass="./target.classes.main" -Dexec.args="./src/main/resources/mixtape.json -c ./src/main/resources/changes.json ./src/main/resources/output.json"

# Scaling #

## If Mixtape.json was too large ##

1. We would need to stream parse the file instead of reading the whole file at the same time.
2. Then we would need to store the data in persistent data store. NoSQL database like MongoDB or Cassandra would work here perfectly.

## Improving Runtime ##

We could execute this using a highly multi-threaded environment. We can spawn threads which will make changes on Mixtape.json simultaneously based off on the different actions seen on the chnages.json file.


# Notes #
1. The changes file has been choosen as a json file and a sample file is present in src/main/resources folder.
2. A sample mixtape.json is also present there.
3. But they can be passed on as arguments along with an output.json file (which needs to be created before passing on the argument)
