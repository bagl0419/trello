package bitlab.trello.controller;

import bitlab.trello.entity.TaskCategory;
import bitlab.trello.exception.TrelloNotFoundException;
import bitlab.trello.service.TaskCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskCategoryController {
    private final TaskCategoryService taskCategoryService;

    @PostMapping("/category/add")
    public String addCategory(TaskCategory taskCategory) {
        taskCategoryService.create(taskCategory);
        return "redirect:/category";
    }

    @PostMapping("/category/edit")
    public String editCategory(TaskCategory taskCategory) {
        taskCategoryService.edit(taskCategory);
        return "redirect:/category";
    }

    @PostMapping("/category/delete/{id}")
    public String deleteCategoryById(@PathVariable Long id) {
        taskCategoryService.deleteById(id);
        return "redirect:/category";
    }

    @GetMapping("/category")
    public String getCategories(Model model) {
        List<TaskCategory> taskCategories = taskCategoryService.getTaskCategories();
        model.addAttribute("categories", taskCategories);
        return "categoryPage";
    }

    @GetMapping("/category/{id}")
    public String getCategoryById(@PathVariable Long id, Model model) throws TrelloNotFoundException {
        TaskCategory taskCategory = taskCategoryService.getById(id);
        model.addAttribute("category", taskCategory);
        return "categoryDetailsPage";
    }
}
