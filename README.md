# Setup PostgreSQL

## Story

To use databases while programming, first we have to install it on our development machine. As we are learning PostgreSQL, we are going to install and configure it and finally learn a way to access it from Python.

## What are you going to learn?

- how to install and setup the `PostgreSQL` database server,
- how to install the `psycopg2` PostgreSQL database driver for Python,
- how to use `psycopg2` to connect to a PostgreSQL database from Python,
- how to manage databases with `psql`,
- how to manage databases from `PyCharm`.


## Tasks


1. Make sure that the latest version of PostgreSQL database corresponding to your OS is installed on your system.

    - Executing first the `sudo updatedb` and after that the `locate bin/postgres` command in the shell shows a valid installation folder of PostgreSQL
    - Executing the `postgres -V` command in the shell (with proper path prefix based on the previous command, e.g. `/usr/bin/postgres -V`) shows a version corresponding to the student's OS ([here](https://www.postgresql.org/download/) can be checked which PostgreSQL version corresponds to which OS)

2. Create a new role called exactly same as your linux username and a new database called `test_db` on your system.

    - Executing the `psql` command in the shell shows a command prompt starting with the student's username (successfully logging into the database automatically created for the user)
    - Executing the `psql -d test_db` in the shell shows a command prompt starting with the database name `test_db` (successfully logging into the database)

3. Connect to your PostgreSQL server with psql and create a table named `dinos` in the `test_db` database and insert the specified data into it. Save the table creation statement in the file called `dinos-create.sql` in the repository. Save the insert statements in the file called `dinos-insert.sql` in the repository.

    - Executing the `\d dinos` commmand in psql after executing the contents of `dinos-create.sql`
while logged into the `test_db` shows the following lines:
    ```
                          Table "public.dinos"
    Column |         Type          | Collation | Nullable | Default
    --------+-----------------------+-----------+----------+---------
    name   | character varying(20) |           |          |
    height | integer               |           |          |
    length | integer               |           |          |
    ```
    - Executing the `SELECT * from dinos;` query after executing the contents of `dinos-insert.sql`
in psql shows the following lines:
    ```
        name       | height | length
    -----------------+--------+--------
    Allosaurus      |      5 |     12
    Apatosaurus     |      5 |     23
    Argentinosaurus |     21 |     37
    Brachiosaurus   |     15 |     31
    Ceratosaurus    |      4 |      6
    Megalosaurus    |      4 |      8
    Oviraptor       |      1 |      2
    Tyrannosaurus   |      7 |     15
    Velociraptor    |      1 |      2
    ```

4. Connect to your PostgreSQL server with PyCharm and run a query in the `test_db` database on the `dinos` table that lists the names of the dinousaurs that are longer than 10 meters. Save the query in the file called `dinos-longer-10.sql` in the repository.

    - Executing the contents `dinos-longer-10.sql` from PyCharm database console shows the following lines:
    ```
    name
    Allosaurus
    Apatosaurus
    Argentinosaurus
    Brachiosaurus
    Tyrannosaurus
    ```

5. Install the `psycopg2` database driver, understand the contents of the `connect_postgres.py` file by commenting above each line what's happenning and finally, edit connection data and run the file.

    - Executing the `pip list | grep psycopg2` in shell shows a line with `psycopg2` (psycopg2 is installed)
    - There is a meaningful comment explaining what's happenning above each code line in `connect_postgres.py`
    - Running `connect_postgres.py` shows `[(1, 100, 'First row'), (2, 100, 'Second row')]` in the terminal


## General requirements


None

## Starting repository

> **For your information**: Unfortunately, GitHub Classroom has an unstable service regarding repository creation and imports. If your repository fails to create or there are issues with code imports you can do the following steps:
>
> 1. Wait. Sometimes it gets done after 1-2 hours.
> 2. Write to your mentors to do it manually for you.
>
> In the meantime, we are working on an own solution to replace GitHub Classroom. We plan to have it in the first quarter of 2020.


Click here to clone your own Git repository:
https://classroom.github.com/a/gvR65ZKk

## Hints

None

## Background materials

- :exclamation: [Installing and setting up PostgreSQL](https://learn.code.cool/full-stack/#/../pages/tools/installing-postgresql.md)
- :exclamation: [Installing psycopg2](https://learn.code.cool/full-stack/#/../pages/tools/installing-psycopg2.md)
- :exclamation: [Setting up a database connection in PyCharm](https://learn.code.cool/full-stack/#/../pages/tools/pycharm-database.md)
- :exclamation: [Short guide about psql](http://postgresguide.com/utilities/psql.html)
- :open_book: [PostgreSQL documentation page about psql](https://www.postgresql.org/docs/current/app-psql.html)

## Acceptance review

You will need this only at review time, **after** completing the project.
[Use this form](https://forms.gle/VUXdx4cB1B5mTo7N8) to record the review you provide for your peer.

For now, you can check your (and everyone else's) results in the [summary spreadsheet](https://docs.google.com/spreadsheets/d/1otJkV-zl-Sfg3BWX1ZbFJ_e-GpLf5Jr6oSysZTfpfD4/edit#gid=31463349).