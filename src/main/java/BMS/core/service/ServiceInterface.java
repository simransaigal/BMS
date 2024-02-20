package BMS.core.service;

import BMS.dto.BookDTO;

import java.util.List;

public interface ServiceInterface<DTO> {
    public List<DTO> get();
    public DTO add(DTO dto);
    public DTO update(DTO dto);
    public DTO delete(DTO dto);
}
