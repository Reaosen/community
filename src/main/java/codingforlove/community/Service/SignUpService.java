package codingforlove.community.Service;

import codingforlove.community.DTO.SignUpDTO;

public interface SignUpService {
    String insertEmailCode(SignUpDTO email);

    void codeCompare(SignUpDTO signUpDTO);

    void insert(SignUpDTO signUpDTO);
}
