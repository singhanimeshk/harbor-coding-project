
# Calendar

A set of APIs for basic Calendar operations




## API Reference

#### Get all calendar schedules

```http
  GET /userSchedules/${userID}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userID` | `string` | **Required**. User ID for whom schedule is to be fetched |

#### Create schedules

```http
  POST /userSchedules/${userID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userID`      | `string` | **Required**. User ID for whom schedule is to be created |
| `schedules list`      | `List<ScheduleRequest>` | **Required**. Schedules where user is busy. Eg: |

```http
[
    {
        "start": "11/07/2022 19:00",
        "end": "21/07/2022 20:00"
    }
]
```

#### Delete schedule

```http
  DELETE /userSchedules/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Schedule ID to be deleted |

#### Find mutually free schedules

```http
  POST /userSchedules/findFreeSchedule
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `users`      | `List<String>` | **Required**. User IDs for whom mutually free schedule to be fetched. Eg: |

```http
{
    "users": ["a", "b"]
}
```

#### Get Scheduler Setting

```http
  GET /schedulerSetting/${userID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userID`      | `string` | **Required**. User ID for whom setting is to be fetched |

#### Create Scheduler Setting

```http
  POST /schedulerSetting/${userID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userID`      | `string` | **Required**. User ID for whom setting is to be created |
| `Scheduler Settings`      | `SchedulerSetting` | **Required**. Busy scheduler setting for the user. Eg:   |

```http
{
    "weeklyBusy": {
        "1": [ {
            "start": "00:00",
            "end": "24:00"
            }
        ],
        "2": [ {
            "start": "00:00",
            "end": "09:00"
            },
            {
            "start": "17:00",
            "end": "24:00"
            }
        ],
        "3": [ {
            "start": "00:00",
            "end": "09:00"
            },
            {
            "start": "17:00",
            "end": "24:00"
            }
        ],
        "4": [ {
            "start": "00:00",
            "end": "09:00"
            },
            {
            "start": "17:00",
            "end": "24:00"
            }
        ],
        "5": [ {
            "start": "00:00",
            "end": "09:00"
            },
            {
            "start": "17:00",
            "end": "24:00"
            }
        ],
        "6": [ {
            "start": "00:00",
            "end": "09:00"
            },
            {
            "start": "17:00",
            "end": "24:00"
            }
        ],
        "7": [ {
            "start": "00:00",
            "end": "24:00"
            }
        ]
    }
}
```

#### Delete Scheduler Setting

```http
  DELETE /schedulerSetting/${userID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userID`      | `string` | **Required**. User ID for whom setting is to be deleted |