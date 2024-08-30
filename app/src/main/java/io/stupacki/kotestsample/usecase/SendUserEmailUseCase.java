package io.stupacki.kotestsample.usecase;

public class SendUserEmailUseCase {

    public String invoke(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@") || !email.contains(".") || !email.endsWith(".de")) {
            throw new InvalidEmailException();
        }
        return email;
    }
}
