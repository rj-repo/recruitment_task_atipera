# Github API Repositories

## Overview
The API give the possibility to retrieve a all repositories for given user.

## API


There are two ways of calling api:
- with github token
- without github token

The main thing is calling Github API without token is very restricted and in most cases will cause block for an hour due to too many requests.

API Limit:
- with token - 5000 requests per hour
- without token - 60 requests per hour

## Stack

- Java 21
- Quarkus 3.19

## How to run

Run the command in maven:
``quarkus:dev``

### Base URL

URL: localhost:8080/api/v1/users

Headers (key: value):
- (optional) Authorization: Bearer token-github


### 1. Get repositires with details


BASE_URL/{username}

## 200 OK

```{
    {
    "username": "username",
    "repositoryUserList": [
        {
            "repoName": "repo1",
            "branches": [
                {
                    "branchName": "master",
                    "lastCommitSHA": "801adc20a49d630bf9d6ab471f18a91570db5656"
                }
            ]
        },
        {
            "repoName": "repo2",
            "branches": [
                {
                    "branchName": "master",
                    "lastCommitSHA": "b39c91030d167f23e92c31b49a6223e89f7b421b"
                }
            ]
        },
}
```

## 404 Not found
When github user is not found
```
{
    "status": 404,
    "response": "Github user not found"
}
```

## 403 Forbidden
When requests limit will be exceeded (mostly when calling API without token)
```
{
    "status": 403,
    "response": "Too many requests - try using a token"
}
```

## 401 Not authorized
When token is invalid maybe getting repositires is not for public purpose
```
{
    "status": 401,
    "response": "Not authorized or wrong token"
}
```
