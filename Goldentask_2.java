import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    private int currentQuestionIndex = 0;

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        List<Question> questions = quizService.getAllQuestions();
        model.addAttribute("question", questions.get(currentQuestionIndex));
        return "quiz";
    }

    @PostMapping("/quiz")
    public String submitAnswer(int answer, Model model) {
        boolean isCorrect = quizService.isCorrectAnswer(currentQuestionIndex, answer);
        model.addAttribute("isCorrect", isCorrect);
        currentQuestionIndex++;

        if (currentQuestionIndex < quizService.getAllQuestions().size()) {
            model.addAttribute("question", quizService.getAllQuestions().get(currentQuestionIndex));
            return "quiz";
        } else {
            return "quizComplete";
        }
    }
}
