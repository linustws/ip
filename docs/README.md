# BorzAI User Guide

## Features

### Basic

- Add, mark , unmark, delete 3 types of tasks: todo, deadline, event.
- Show list of tasks.
- Loads and saves tasks from and to hard-disk.

### Filter and Sort

- Filter tasks using keywords or dates.
- Sort tasks by alphabetical order, dates, task type or status(marked/unmarked).

## How to run BorzAI

1. Ensure that you have downloaded the latest version of Borzai under Releases in GitHub.
2. Copy the jar file into an empty folder.
3. Open a command window in that folder.
4. Run the command java -jar BorzAi-{version}.jar e.g., java -jar BorzAI-v1.0.jar (i.e., run the command in the same
   folder as the jar file).

## List of Commands

- `todo <description>` Add todo.
- `deadline <description> /by <date/time>` Add deadline.
- `event <description> /from <date/time> /to <date/time>`Add event.
- `list` Show tasks.
- `mark <number>` Mark task.
- `unmark <number>` Unmark task.
- `delete <number>` Delete task.
- `filter <keywords...>` Filter tasks by keyword(s), separate multiple keywords with commas.
- `filterdate <dates...>` Filter tasks by date(s), separate multiple dates with commas.
- `sort` Sort tasks by alphabetical order.
- `sortdate` Sort tasks by date.
- `sorttask` Sort tasks by task type.
- `sortdone` Sort tasks by status.

## Export and import

1. Run BorzAI at least once and exit it.
2. Copy the `tasks.ser` file from the location that you want to export from.
3. Paste it into the `data` folder that should have been auto-created. Overwrite the existing file.
4. Run BorzAI and enter `list` command to show updated tasks.

<div style="text-align:center">
   <img width="590" alt="Ui" src="https://user-images.githubusercontent.com/97421565/220763976-1de030d8-524c-47a3-a534-2852a775d466.png">
</div>
