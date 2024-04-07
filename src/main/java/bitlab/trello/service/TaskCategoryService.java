package bitlab.trello.service;

import bitlab.trello.entity.TaskCategory;
import bitlab.trello.exception.TrelloNotFoundException;
import bitlab.trello.repository.TaskCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskCategoryService {
    private final TaskCategoryRepository taskCategoryRepository;

    /**
     * Метод для добавления категории задачи.
     *
     * @param taskCategory - данные из формы ввода (ID отсутствует).
     * @return - сохраненный в БД объект.
     */
    public TaskCategory create(TaskCategory taskCategory) {
        log.info("STARTED creation taskCategory: {}", taskCategory);
        TaskCategory saved = taskCategoryRepository.save(taskCategory);
        log.info("COMPLETED creation taskCategory ID: {}", saved.getId());
        return saved;
    }

    /**
     * Метод для изменения категории задачи.
     *
     * @param taskCategory - данные из формы ввода (есть ID).
     * @return - сохраненный в БД объект.
     */
    public TaskCategory edit(TaskCategory taskCategory) {
        log.info("STARTED editing taskCategory: {}", taskCategory);
        TaskCategory saved = taskCategoryRepository.save(taskCategory);

        log.info("COMPLETED editing taskCategory ID: {}", saved.getId());
        return saved;
    }

    /**
     * Метод для удаления категории задачи по ID
     * @param id - идентификатор taskCategory.
     */
    public void deleteById(Long id) {
        log.info("STARTED deletion taskCategory ID: {}", id);
        taskCategoryRepository.deleteById(id);

        log.info("COMPLETED deletion taskCategory ID: {}", id);
    }

    /**
     * Метод для получения всех категории задачи.
     * @return - список всех категории задачи.
     */
    public List<TaskCategory> getTaskCategories() {
        return taskCategoryRepository.findAll();
    }

    /**
     * Метод для получения категории задачи по ID.
     * @param id - идентификатор категории задачи.
     * @return - категория задачи из БД по ID.
     * @throws TrelloNotFoundException - исключение, если объект не найден.
     */
    public TaskCategory getById(Long id) throws TrelloNotFoundException {
        String message = String.format("TaskCategory ID: %s NOT FOUND", id);
        return taskCategoryRepository.findById(id).
                orElseThrow(() -> new TrelloNotFoundException(message));
    }
}
