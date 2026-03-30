package project3.example.project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Smart Job Portal!");
        return "home";
    }

    @GetMapping("/jobs")
    public String jobs() {
        return "job";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    // ✅ BACKEND FILE UPLOAD LOGIC (ADDED)
    @PostMapping("/upload")
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) {

        // ❌ If no file selected
        if (file.isEmpty()) {
            model.addAttribute("message", "❌ Please select a file!");
            return "upload";
        }

        try {
            // 📁 Folder to save files
            String uploadDir = "uploads/";
            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs(); // create folder if not exists
            }

            // 📄 Save file
            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            // ✅ Success message
            model.addAttribute("message", "🎉 Thank you! Resume uploaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "❌ Upload failed. Try again!");
        }

        return "upload";
    }
}