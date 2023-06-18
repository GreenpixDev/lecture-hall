# OpenAPI definition
## Version: v0

### /videos/{videoId}

#### GET
##### Summary:

Получение информации о видео

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| videoId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

#### PUT
##### Summary:

Обновление видео

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| videoId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

#### DELETE
##### Summary:

Удаление видео

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| videoId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /subjects/{subjectId}

#### PUT
##### Summary:

Обновление предмета

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| subjectId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

#### DELETE
##### Summary:

Удаление предмета

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| subjectId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /invitations/{invitationId}

#### PUT
##### Summary:

Обновление приглашения

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| invitationId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

#### DELETE
##### Summary:

Удаление приглашения

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| invitationId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}

#### PUT
##### Summary:

Обновление группы

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

#### DELETE
##### Summary:

Удаление группы

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/members/{userId}

#### PUT
##### Summary:

Обновить участника в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| userId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

#### DELETE
##### Summary:

Кикнуть участника из группы

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| userId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/videos/search

#### POST
##### Summary:

Поиск видео в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| page | query |  | No | integer |
| count | query |  | No | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/videos/new

#### POST
##### Summary:

Создание видео в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/tags/search

#### POST
##### Summary:

Поиск тегов в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| page | query |  | No | integer |
| count | query |  | No | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/subjects/search

#### POST
##### Summary:

Поиск предметов в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| page | query |  | No | integer |
| count | query |  | No | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/subjects/new

#### POST
##### Summary:

Создание предмета в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/members/search

#### POST
##### Summary:

Список участников в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| page | query |  | No | integer |
| count | query |  | No | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/invitations/new

#### POST
##### Summary:

Создание приглашения в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/exit

#### POST
##### Summary:

Выйти из группы

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/search

#### POST
##### Summary:

Поиск групп

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| page | query |  | No | integer |
| count | query |  | No | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/new

#### POST
##### Summary:

Создание группы

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/entrance

#### POST
##### Summary:

Присоединение к группе по коду приглашения

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /user/me

#### GET
##### Summary:

Информация о себе

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |

### /groups/{groupId}/invitations

#### GET
##### Summary:

Список приглашений в группе

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| groupId | path |  | Yes | string (uuid) |
| page | query |  | No | integer |
| count | query |  | No | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 400 | Bad Request |
| 401 | Unauthorized |
| 500 | Internal Server Error |
