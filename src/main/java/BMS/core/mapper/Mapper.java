package BMS.core.mapper;

public interface Mapper<DTO,Entity> {
    Entity DTOtoEntity(DTO dto);

    DTO entityToDTO(Entity entity);

}
