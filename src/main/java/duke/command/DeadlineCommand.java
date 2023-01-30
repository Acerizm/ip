package duke.command;

import duke.data.TaskList;
import duke.data.TypeOfTask;
import duke.event.Deadline;
import duke.event.Task;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;

public class DeadlineCommand extends Command{
    public DeadlineCommand(String[] contents) {
        super(contents,false);
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        // 1. get the description of the command
        String description = super.parser.convertToUserInput(super.contents,TypeOfTask.deadline,"");
        String[] dateTime = super.parser.convertToUserInput(super.contents,TypeOfTask.deadline,"/by").split(" "); 
        Task newTask = new Deadline(description,dateTime[0],dateTime[1]);
        taskList.addTask(newTask);
        ui.displayResult(TypeOfTask.deadline, newTask, taskList);
    }
}
