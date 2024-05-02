package deu.se.ood.controller;

import deu.se.ood.model.ch06.AddrBookManager;
import deu.se.ood.model.ch06.AddrBookRow;
import deu.se.ood.model.ch06.HikariConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@PropertySource("classpath:/config.properties")
public class Ch06Controller {

    @Value("${mysql.server.ip}")
    private String ip;
    @Value("${mysql.server.port}")
    private String port;
    @Autowired
    private Environment env;
    @Autowired
    private HikariConfiguration dbConfig;

    @GetMapping("/ch06/showtable1")
    public String showTable1(Model model) {
        model.addAttribute("mysql_server_ip", this.ip);
        model.addAttribute("mysql_server_port", this.port);
        log.info("mysql.server.ip = {}, mysql.server.port = {}", this.ip, this.port);
        return "ch06/showtable1/index";
    }

    @GetMapping("/ch06/showtable2")
    public String showTable2(Model model) {
        model.addAttribute("mysql_server_ip", this.ip);
        model.addAttribute("mysql_server_port", this.port);
        log.info("mysql.server.ip = {}, mysql.server.port = {}", this.ip, this.port);

        return "ch06/showtable2/index";
    }

    @GetMapping("/ch06/inserttable")
    public String insertTable(Model model) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");
        log.debug("ip ={}, port = {}", this.ip, this.port);

        AddrBookManager manager = new AddrBookManager(this.ip, this.port, jdbcDriver, userName, password);

        List<AddrBookRow> dataRows = manager.getAllRows();
        model.addAttribute("dataRows", dataRows);

        return "ch06/inserttable/index";
    }

    @GetMapping("/ch06/insert_addrbook")
    public String insertAddrBook() {
        return "ch06/inserttable/insert_addrbook";
    }

    @PostMapping("/ch06/insert.do")
    public String insertAddrBook(@RequestParam String email, @RequestParam String name, @RequestParam String phone) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");

        AddrBookManager manager = new AddrBookManager(this.ip, this.port, jdbcDriver, userName, password);
        manager.addRow(email, name, phone);
        // redirect => response.sendRedirect() 함수를 호출
        return "redirect:/ch06/inserttable";
    }

    @GetMapping("/ch06/delete_addrbook")
    public String deleteAddrBook(Model model) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");


        AddrBookManager manager = new AddrBookManager(this.ip, this.port, jdbcDriver, userName, password);

        List<AddrBookRow> dataRows = manager.getAllRows();
        model.addAttribute("dataRows", dataRows);

        return "ch06/inserttable/delete_addrbook";
    }

    @PostMapping("/ch06/delete.do")
    public String deleteAddrBook(@RequestParam String email) {
        String userName = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String jdbcDriver = env.getProperty("spring.datasource.driver-class-name");

        AddrBookManager manager = new AddrBookManager(this.ip, this.port, jdbcDriver, userName, password);
        manager.deleteRow(email);

        return "redirect:/ch06/inserttable";
    }

    @GetMapping("/ch06/hikari_cp")
    public String hikariCP(Model model) {
        model.addAttribute("dbConfig", dbConfig);
        return "ch06/hikari_cp/index";
    }
}

