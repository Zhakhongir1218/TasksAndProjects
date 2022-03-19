# TasksAndProjects
 Implement Web API for entering project data into the database (task tracker)

Project controller
Is quite easy to create a new Project, just need to enter the project 
name and write down it's priority(from 1 to 10).
![Снимок экрана 2022-03-20 в 01 01 10](https://user-images.githubusercontent.com/95052692/159135545-ce90c3af-79a2-47d5-a52d-a024847afcc9.png)

Here is the our result in DB during the creating proccess project status will be automaticly changed to NOT_STARTED,
if you want to change the project status use updateProjectStatus controller.
![Снимок экрана 2022-03-20 в 01 01 47](https://user-images.githubusercontent.com/95052692/159135550-e496e798-d234-4545-920b-043fc83cc690.png)

This controller just delete projects by id. 
We have a protection, if project status will be qual to ACTIVE, our service will
not allow us to delete this project.
![Снимок экрана 2022-03-20 в 01 02 00](https://user-images.githubusercontent.com/95052692/159135551-1012453b-1d5f-4cf6-9070-5a0a85bf41c3.png)

Just getting all projects.
![Снимок экрана 2022-03-20 в 01 02 15](https://user-images.githubusercontent.com/95052692/159135552-bcfb2a10-fcbf-4f8a-9c95-09222f2a65d4.png)

Getting all sorted projects by priority desc(the highest priority will be at top of the list).
![Снимок экрана 2022-03-20 в 01 02 35](https://user-images.githubusercontent.com/95052692/159135553-323721b5-e8ab-4d0d-9447-ec366fcfbc35.png)
Result:
![Снимок экрана 2022-03-20 в 01 02 45](https://user-images.githubusercontent.com/95052692/159135554-8acf0afc-f58d-43d6-b6b2-95e3e24d7421.png)

Changing project status by id.
![Снимок экрана 2022-03-20 в 01 03 07](https://user-images.githubusercontent.com/95052692/159135555-c50f7e2b-d5e5-4cf3-811a-419c5e6cd092.png)
Result:
![Снимок экрана 2022-03-20 в 01 03 20](https://user-images.githubusercontent.com/95052692/159135556-d0c8bb05-d432-4b4b-8bde-f720e623c75d.png)

Is quite easy to create a new Task, just need to enter the Task 
name, Task description, project id and write down task's priority(from 1 to 10).
![Снимок экрана 2022-03-20 в 01 05 15](https://user-images.githubusercontent.com/95052692/159135557-4ed79e66-2f59-46e2-8109-57c20b8afce4.png)

Here is the our result in DB during the creating proccess project status will be automaticly changed to TO_DO,
if you want to change the project status use updateTaskStatus controller
![Снимок экрана 2022-03-20 в 01 05 37](https://user-images.githubusercontent.com/95052692/159135560-ff06043d-9998-4263-9c0f-bca666fda5b4.png)

This controller just delete tasks by id. 
We have a protection, if task status will be qual to IN_PROGRESS, our service will
not allow us to delete this project.
![Снимок экрана 2022-03-20 в 01 05 52](https://user-images.githubusercontent.com/95052692/159135561-9e1d2dd0-d9e4-48d9-a283-45fc0565b597.png)

Just getting all tasks.
![Снимок экрана 2022-03-20 в 01 06 09](https://user-images.githubusercontent.com/95052692/159135562-e0e7b50c-5f58-48c4-9dc9-ced6fe08a66e.png)

Result:
![Снимок экрана 2022-03-20 в 01 06 25](https://user-images.githubusercontent.com/95052692/159135563-56ac3483-4fff-4674-98b4-f9cba1db723a.png)

Getting all tasks by project id and automaticly sort it by priority desc.
![Снимок экрана 2022-03-20 в 01 07 47](https://user-images.githubusercontent.com/95052692/159135565-74ecdce5-414d-4980-aa73-e7450fa585c4.png)

Result:
![Снимок экрана 2022-03-20 в 01 08 06](https://user-images.githubusercontent.com/95052692/159135567-f0ca552e-5262-426a-82fa-0174f85a888c.png)
![Снимок экрана 2022-03-20 в 01 08 13](https://user-images.githubusercontent.com/95052692/159135569-f4434e4d-fd01-4469-b485-e17c40bf4691.png)
![Снимок экрана 2022-03-20 в 01 08 24](https://user-images.githubusercontent.com/95052692/159135570-1efccb54-e51b-4948-8c02-8d0bd3c194c3.png)

Changing task status by id.
![Снимок экрана 2022-03-20 в 01 08 52](https://user-images.githubusercontent.com/95052692/159135571-8d9ebab1-371e-4309-83c5-ad3cde3b0e14.png)

Result:
![Снимок экрана 2022-03-20 в 01 09 12](https://user-images.githubusercontent.com/95052692/159135573-7da3da78-a6cd-40a2-b7c9-7420cbba1b7d.png)
