package org.jose.lispvalidator.logic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParenthesesValidatorTest {
    @Test
    public void testValidate() {
        String lispContents = """
                (defun factorial (n)
                  (if (<= n 1)
                    1
                    (* n (factorial (- n 1)))
                  )
                )
                """;
        boolean isValid = ParenthesesValidator.validate(lispContents);
        assertTrue(isValid);
    }

    @Test
    public void testValidateInvalid() {
        String lispContents = """
                (defun factorial (n)
                  (if (<= n 1)
                    1
                    (* n (factorial (- n 1)))
                  )
                ))
                """;
        boolean isValid = ParenthesesValidator.validate(lispContents);
        assertFalse(isValid);
    }

    @Test
    public void testValidateEmpty() {
        String lispContents = "";
        boolean isValid = ParenthesesValidator.validate(lispContents);
        assertTrue(isValid);
    }

    @Test
    public void testValidateNull() {
        boolean isValid = ParenthesesValidator.validate(null);
        assertTrue(isValid);
    }
}
