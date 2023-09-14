## Character Frequency REST API
Test task for T1Consulting

You can find the original text of the task in testtask.txt file in this repository.


This REST API calculates the frequency of characters in a given string and sorts the result in descending order of occurrence.

**Endpoint:** `/api/character-frequency`

Two types of requests could be processed

- **HTTP Method:** GET

**Request Parameters:**

- `input` (string): The input string for which you want to calculate character frequency.

**Example Request:**
```
GET /api/character-frequency?input=aaaaabcccc
```
**Example Response**
```
{a=5, c=4, b=1}
```

Please keep in mind that HTTP GET requests can use characters like "#%^&{}[]\" as parameters, but these characters have special meanings in URLs and are reserved. To include them as parameters, you should encode them properly to prevent conflicts with URL syntax.

- **HTTP Method:** POST

**Request Body:**

- `JSON` The input string for which you want to calculate character frequency.

**Example Request:**
```
{
    "input": "aaaaabcccc"
}
```
**Example Response**
```
{
    "a": 5,
    "c": 4,
    "b": 1
}
```

In that case you could use any characters whatever you want.

In both cases input data can not be empty. The API issues a corresponding message.


## Running the Application

You will need following software:
> JRE

> IDE (IntelliJ IDEA, Eclipse or equivalent)

> Maven

> Postman (in case you want to test it locally)

Then clone this repository to any folder on your computer:
```
https://github.com/TimurSelivanov/T1ConsultingTestTask.git
```

Open project with your IDE, and run T1ConsultingTestTaskApplication.

If you have any comments and suggestions for improving this code, and if you'd like to share your ideas, please feel free to reach out to me on LinkedIn.

## Technology stack
Java 8+, Spring Boot 2+, Spring Web, Hibernate Validation, Stream API, JUnit, AssertJ, Mockito.