public class DeleteTaskCommand extends Command {

    String itemIndex;

    public DeleteTaskCommand(String itemIndex) {
        this.itemIndex = itemIndex;
    }

    public boolean isTerminated() {
        return false;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) {
        // convert string to int
        int index = Integer.parseInt(itemIndex) - 1;
        try {
            if (index < 0 || index >= tasklist.size()) {
                throw new InvalidIndexException();
            } else {
                Task item = tasklist.get(index);
                // delete task
                tasklist.remove(index);
                ui.sendMessage("Noted. I've removed this task: ");
                ui.sendMessage("  " + item.toString());
                ui.sendMessage(String.format("Now you have %d tasks in the list.", tasklist.size()));
            }
        } catch (DukeException error) {
            ui.sendMessage(error.toString());
        }
    }

}