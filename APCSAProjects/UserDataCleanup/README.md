(7.4.8 - User Data Cleanup)

Desc.
This program prints out a List of names consisting of non-duplicate and "correctly formatted" words. (However, not all the words are correctly formatted but recieved a passing grade, indicating that the auto-grader is broken.)

Assignment Desc:
Your company is doing some data cleanup, and notices that the list of all users has been getting outdated.
For one, there are some users who have been added multiple times.

Your job is to create a series of methods that can purge some of the old data from the existing list.

Create static methods in the DataPurge class that can do the following:

removeDuplicates() - This method takes a list of people, and removes the duplicate names. It also prints to the console which duplicate names have been removed.
removeName() - This method takes a list of people and name for which to search. It removes all names that match the search name (whether the name matches the first name or the last name or both). It should print to the console any names that were removed.
correctlyFormatted() - This method returns true if all of the data in the list is formatted correctly. Correctly formatted names are made up of a first name and a last name, separated by a single space. Both the first and last names should start with an uppercase letter.
