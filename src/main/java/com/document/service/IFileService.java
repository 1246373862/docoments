package com.document.service;

import com.document.entity.FileDocument;
import com.document.entity.dto.BasePageDTO;
import com.document.entity.dto.DocumentDTO;
import com.document.entity.dto.document.UpdateInfoDTO;
import com.document.enums.DocStateEnum;
import com.document.task.exception.TaskRunException;
import com.document.util.BaseApiResult;
import org.apache.http.auth.AuthenticationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


/**
 * @author hangfeng.ying
 */
public interface IFileService {


    /**
     * 保存文件 - 表单
     *
     * @param md5 文件md5
     * @param file 问价数据
     * @return FileDocument
     */
    FileDocument saveFile(String md5, MultipartFile file);


    BaseApiResult documentUpload(MultipartFile file, String userId, String username) throws AuthenticationException;

    BaseApiResult uploadBatch(String category, List<String> tags, String description,
                              Boolean skipError, MultipartFile[] files,
                              String userId, String username);

    BaseApiResult uploadByUrl(String category, List<String> tags, String name,
                              String description, String url,
                              String userId, String username);


    /**
     * 保存文件 - js文件流
     *
     * @param fileDocument FileDocument
     * @param inputStream InputStream
     * @return FileDocument FileDocument
     */
    FileDocument saveFile(FileDocument fileDocument, InputStream inputStream);

    /**
     * update file
     * @Author yinghangfeng
     * @Description 重建索引和缩略图的时候专用的
     * @Date 18:05 2022/11/13
     * @Param fileDocument FileDocument
     **/
    void updateFile(FileDocument fileDocument);

    /**
     * @Author yinghangfeng
     * @Description // 更新文档状态
     * @Date 15:41 2022/11/13
     * @Param [fileDocument, state]
     **/
    void updateState(FileDocument fileDocument, DocStateEnum state, String errorMsg) throws TaskRunException;

    /**
     * @Author yinghangfeng
     * @Description // 删除GridFS系统中的文件
     * @Date 18:02 2022/11/13
     * @Param [id]
     **/
    void deleteGridFs(String ...id);

    /**
     * 删除文件
     *
     * @param id
     * @param isDeleteFile 是否删除文件
     * @return
     */
    void removeFile(String id, boolean isDeleteFile);

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    Optional<FileDocument> getById(String id);

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    Optional<FileDocument> getPreviewById(String id);

    /**
     * 根据md5获取文件对象
     *
     * @param md5
     * @return
     */
    FileDocument getByMd5(String md5);

    /**
     * queryById
     * @param docId String
     * @return result
     */
    FileDocument queryById(String docId);

    /**
     * 分页查询，按上传时间降序
     *
     * @param pageIndex 页数
     * @param pageSize 每页数量
     * @return List<FileDocument>
     */
    List<FileDocument> listFilesByPage(int pageIndex, int pageSize);

    /**
     * listAndFilterByPage
     * @param pageIndex int
     * @param pageSize int
     * @param ids Collection
     * @return result
     */
    List<FileDocument> listAndFilterByPage(int pageIndex, int pageSize, Collection<String> ids);

    /**
     * listAndFilterByPageNotSort
     * @param pageIndex int
     * @param pageSize int
     * @param ids List
     * @return result
     */
    List<FileDocument> listAndFilterByPageNotSort(int pageIndex, int pageSize, List<String> ids);

    /**
     * 分页检索目前的文档信息
     * @param documentDTO DocumentDTO
     * @return result
     */
    BaseApiResult list(DocumentDTO documentDTO);

    /**
     *根据文档的详情，查询该文档的详细信息
     *
     * @param id ->Long
     * @return ApiResult
     */
    BaseApiResult detail(String id);

    /**
     * 删除掉已经存在的文档
     *
     * @param fileDocument -> 文档信息
     * @return ApiResult
     */
    BaseApiResult remove(FileDocument fileDocument);

    /**
     * @Author yinghangfeng
     * @Description 管理员对文档的基本信息进行修改
     * @Date 23:17 2023/6/28
     * @Param [updateInfoDTO]
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult updateInfo(UpdateInfoDTO updateInfoDTO);


    BaseApiResult listWithCategory(DocumentDTO documentDTO);

    /**
     * update file thumb
     * @param inputStream FileDocument
     * @param fileDocument InputStream
     * @throws FileNotFoundException file not found
     */
    void updateFileThumb(InputStream inputStream, FileDocument fileDocument) throws FileNotFoundException;

    /**
     * getFileThumb
     * @Author yinghangfeng
     * @Description // 查询缩略图信息
     * @Date 8:00 下午 2022/7/24
     * @param thumbId String
     * @return java.io.InputStream
     **/
    InputStream getFileThumb(String thumbId);

    byte[] getFileBytes(String thumbId);

    /**
     * 保存文件流到dfs系统中
     **/
    String uploadFileToGridFs(String prefix, InputStream in, String contentType);

    /**
     * @Author yinghangfeng
     * @Description 查询并删除某个文档
     * @Date 10:01 2022/12/10
     * @Param [docId]
     * @return com.document.entity.FileDocument
     **/
    List<FileDocument> queryAndRemove(String ...docId);

    /**
     * @Author yinghangfeng
     * @Description 文档查询并通过文档审批
     * @Date 10:27 2022/12/10
     * @Param [docId]
     * @return java.util.List<com.document.entity.FileDocument>
     **/
    List<FileDocument> queryAndUpdate(String ...docId);

    /**
     * @Author yinghangfeng
     * @Description 查询是否在评审的文档
     * @Date 12:02 2022/12/10
     * @Param [pageDTO, reviewing]
     * @return java.util.List<com.document.entity.FileDocument>
     **/
    List<FileDocument> queryFileDocument(BasePageDTO pageDTO, boolean reviewing);

    /**
     * @Author yinghangfeng
     * @Description 查询文档评审的列表, 实际是查询文档的信息
     * @Date 20:45 2022/11/30
     * @Param [page, user]
     * @return com.document.util.BaseApiResult
     **/
    BaseApiResult queryFileDocumentResult(BasePageDTO pageDTO, boolean reviewing);
}
