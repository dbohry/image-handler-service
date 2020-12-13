# Image handler Service

This is a springboot service that provide a few APIs.

## Runtime Dependencies

* JDK11

## Install dependencies

```
$ chmod +x gradlew
$ bash gradlew clean build --refresh-dependencies
```

## Run it locally

`bash gradlew bootrun`

## Run test

`bash gradlew clean test`

## API

```
Request:
GET /features

Response:
[
  {
      "id": "39c2f29e-c0f8-4a39-a98b-deed547d6aea",
      "timestamp": 1554831167697,
      "beginViewingDate": 1554831167697,
      "endViewingDate": 1554831202043,
      "missionName": "Sentinel-1"
  },
  {
      "id": "cf5dbe37-ab95-4af1-97ad-2637aec4ddf0",
      "timestamp": 1556904743783,
      "beginViewingDate": 1556904743783,
      "endViewingDate": 1556904768781,
      "missionName": "Sentinel-1"
  }
]
```

```
Request:
GET /features/cf5dbe37-ab95-4af1-97ad-2637aec4ddf0

Response:
{
    "id": "cf5dbe37-ab95-4af1-97ad-2637aec4ddf0",
    "timestamp": 1556904743783,
    "beginViewingDate": 1556904743783,
    "endViewingDate": 1556904768781,
    "missionName": "Sentinel-1"
  }
```

```
Request:
GET /features/cf5dbe37-ab95-4af1-97ad-2637aec4ddf0/quicklook

Response:
![alt text](https://i.imgur.com/ix27vZa.png)

```