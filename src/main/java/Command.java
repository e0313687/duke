public abstract class Command {
        public abstract void execute(Ui ui, Storage storage) throws DukeException;
}
