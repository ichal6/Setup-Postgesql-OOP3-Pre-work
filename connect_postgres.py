import psycopg2


def main():
    try:

        user_name = "your db username"
        password = "your password"
        host = "usually it is: localhost"
        database_name = "name of the db you want to open"

        connect_str = "postgresql://{user_name}:{password}@{host}/{database_name}".format(
            user_name=user_name,
            password=password,
            host=host,
            database_name=database_name
        )
        print("Connection string: " + connect_str)

        connection = psycopg2.connect(connect_str)

        connection.autocommit = True

        cursor = connection.cursor()

        cursor.execute("DROP TABLE IF EXISTS test;")

        cursor.execute("CREATE TABLE test (id serial PRIMARY KEY, num integer, data varchar);")

        cursor.execute("INSERT INTO test (num, data) VALUES (%s, %s)", (100, "First row"))
        cursor.execute("INSERT INTO test (num, data) VALUES (%s, %s)", (100, "Second row"))

        cursor.execute("SELECT * FROM test;")
        rows = cursor.fetchall()
        print(rows)

        cursor.close()

    except psycopg2.DatabaseError as exception:
        print(exception)

    finally:
        if 'connection' in locals():
            connection.close()


if __name__ == '__main__':
    main()
