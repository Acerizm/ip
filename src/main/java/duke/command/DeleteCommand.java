package duke.command;

import duke.data.TaskList;
import duke.data.TypeOfTask;
import duke.event.Task;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    
    public DeleteCommand(String[] contents) {
        super(contents, false);
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws NumberFormatException, DukeException {
        int taskIndexDelete = Integer.parseInt(super.parser.convertToUserInput(contents,TypeOfTask.delete,"")) - 1;
        Task taskToBeDeleted = taskList.getTaskByIndex(taskIndexDelete);
        System.out.println("Noted! I've removed this task:");
        System.out.println(String.format("%d. %s",taskIndexDelete + 1,taskToBeDeleted.toString()));
        taskList.removeTask(taskIndexDelete);
        ui.displayResult(TypeOfTask.delete, null, taskList);
    }
}
