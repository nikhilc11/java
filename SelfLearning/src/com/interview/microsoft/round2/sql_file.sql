CREATE TABLE E01_BIDHE_SDS_epm365_WRK.gp_funding_chapterarea_allocation_stitchedrecords 
USING PARQUET LOCATION 'abfss:REDACTED_LOCAL_PART@tcpazbiddc1ntcpdevds1.dfs.core.windows.net/app_root/bidh/data/E01/SDS/cdc/reference/epm365/E01_BIDHE_SDS_EPM365_WRK/gp_funding_chapterarea_allocation_stitchedrecords'   
AS 
WITH 
cte_gp_funding_chapterarea_allocation_delta           AS (  SELECT * FROM E01_BIDHE_SDS_epm365_HIST.gp_funding_chapterarea_allocation_delta  ) , 
cte_gp_funding_chapterarea_allocation_Standardised    AS (  SELECT * FROM E01_BIDHE_SDS_epm365_WRK.gp_funding_chapterarea_allocation_Standardised  ) , 
cte_gp_funding_chapterarea_allocation_denoised        AS (  SELECT n.FUNDING_ID,n.ID,n.CODE,n.CHAPTER_AREA,n.CAPEX_SPLIT,n.OPEX_SPLIT,n.TOTAL_FTE,n.CREATED_BY,n.CREATED_DATE,n.LAST_UPDATED_BY,n.LAST_UPDATED_DATE,n.CALCULATED_CAPEX_AMOUNT,n.CALCULATED_OPEX_AMOUNT,n.effectivestartutcdttm, cast(NULL as timestamp) AS effectiveendutcdttm,n.fileid,n.filelinenumber,n.inserttaskid from cte_gp_funding_chapterarea_allocation_Standardised n LEFT OUTER JOIN cte_gp_funding_chapterarea_allocation_delta h ON ( h.effectiveendutcdttm = cast('9999-12-31 23:59:59' as timestamp) AND n.ID=h.ID ) WHERE ((  h. ID is NULL   AND h.fileid is null ) OR NOT ( n.FUNDING_ID <=> h.FUNDING_ID AND n.CODE <=> h.CODE AND n.CHAPTER_AREA <=> h.CHAPTER_AREA AND n.CAPEX_SPLIT <=> h.CAPEX_SPLIT AND n.OPEX_SPLIT <=> h.OPEX_SPLIT AND n.TOTAL_FTE <=> h.TOTAL_FTE AND n.CREATED_BY <=> h.CREATED_BY AND n.CREATED_DATE <=> h.CREATED_DATE AND n.LAST_UPDATED_BY <=> h.LAST_UPDATED_BY AND n.LAST_UPDATED_DATE <=> h.LAST_UPDATED_DATE AND n.CALCULATED_CAPEX_AMOUNT <=> h.CALCULATED_CAPEX_AMOUNT AND n.CALCULATED_OPEX_AMOUNT <=> h.CALCULATED_OPEX_AMOUNT    ))  ) ,
cte_gp_funding_chapterarea_allocation_affectedrecords AS (  SELECT h.FUNDING_ID,h.ID,h.CODE,h.CHAPTER_AREA,h.CAPEX_SPLIT,h.OPEX_SPLIT,h.TOTAL_FTE,h.CREATED_BY,h.CREATED_DATE,h.LAST_UPDATED_BY,h.LAST_UPDATED_DATE,h.CALCULATED_CAPEX_AMOUNT,h.CALCULATED_OPEX_AMOUNT,h.effectivestartutcdttm,h.effectiveendutcdttm,h.fileid,h.filelinenumber,h.inserttaskid,h.effectivestartutcdtprtnkey, true METADATA_EXISTING_RECORD from cte_gp_funding_chapterarea_allocation_delta h LEFT SEMI JOIN cte_gp_funding_chapterarea_allocation_denoised n ON ( h.effectiveendutcdttm = cast('9999-12-31 23:59:59' as timestamp) AND h.ID=n.ID ) UNION  ALL select n.FUNDING_ID,n.ID,n.CODE,n.CHAPTER_AREA,n.CAPEX_SPLIT,n.OPEX_SPLIT,n.TOTAL_FTE,n.CREATED_BY,n.CREATED_DATE,n.LAST_UPDATED_BY,n.LAST_UPDATED_DATE,n.CALCULATED_CAPEX_AMOUNT,n.CALCULATED_OPEX_AMOUNT,n.effectivestartutcdttm, cast(NULL as timestamp) effectiveendutcdttm ,n.fileid,n.filelinenumber,n.inserttaskid, CAST(REPLACE(TO_DATE(n.effectivestartutcdttm),'-','') AS INT) effectivestartutcdtprtnkey , false METADATA_EXISTING_RECORD  from cte_gp_funding_chapterarea_allocation_denoised n  ) ,
cte_gp_funding_chapterarea_allocation_stitchedrecords AS (  SELECT * FROM ( select n.FUNDING_ID,n.ID,n.CODE,n.CHAPTER_AREA,n.CAPEX_SPLIT,n.OPEX_SPLIT,n.TOTAL_FTE,n.CREATED_BY,n.CREATED_DATE,n.LAST_UPDATED_BY,n.LAST_UPDATED_DATE,n.CALCULATED_CAPEX_AMOUNT,n.CALCULATED_OPEX_AMOUNT,n.effectivestartutcdttm, COALESCE( LEAD(effectivestartutcdttm - interval 1 second ) OVER (PARTITION BY  n.ID order by n.effectivestartutcdttm),cast('9999-12-31 23:59:59' as timestamp) ) effectiveendutcdttm ,n.fileid,n.filelinenumber,n.inserttaskid,from_utc_timestamp(now(),'Australia/Melbourne') as publicationstartdttm,cast('9999-12-31 23:59:59' as timestamp) as publicationenddttm,n.effectivestartutcdtprtnkey, METADATA_EXISTING_RECORD from cte_gp_funding_chapterarea_allocation_affectedrecords n )   
															<bound method ChangeDataCapture.generate_sql_union_deletes of <patterns.changedatacapture.cdc_optimized.ChangeDataCapture object at 0x7f75780a6460>>  
														 )    
SELECT * FROM cte_gp_funding_chapterarea_allocation_stitchedrecords












CREATE TABLE E01_BIDHT_SDS_FLEXCAB_WRK.T04035_CRRR_CSTMR_TABLE_stitchedrecords 
USING PARQUET LOCATION 'abfss:REDACTED_LOCAL_PART@tcpazbiddc1ntcpdevds1.dfs.core.windows.net/app_root/bidh/data/E01/SDS/cdc/transient/flexcab/E01_BIDHT_SDS_FLEXCAB_WRK/t04035_crrr_cstmr_table_stitchedrecords'   
AS 
WITH   
cte_T04035_CRRR_CSTMR_TABLE_delta           AS (  SELECT * FROM E01_BIDHT_SDS_FLEXCAB_HIST.T04035_CRRR_CSTMR_TABLE_delta  ) ,   
cte_T04035_CRRR_CSTMR_TABLE_Standardised    AS (  SELECT * FROM E01_BIDHT_SDS_FLEXCAB_WRK.T04035_CRRR_CSTMR_TABLE_Standardised  ) ,  
cte_T04035_CRRR_CSTMR_TABLE_internaldenoise AS (  select * from (SELECT keyed.*,  
                                                      CASE WHEN LAG (CRRR_ID) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS NULL THEN 1 
                                                           WHEN LAG (DELTA_SQNC_NUM) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM DELTA_SQNC_NUM THEN 1  
                                                           WHEN LAG (INVC_ARRNT_ID) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM INVC_ARRNT_ID THEN 1  
                                                           WHEN LAG (CRRR_ID) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM CRRR_ID THEN 1  
                                                           WHEN LAG (EPAC) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM EPAC THEN 1  
                                                           WHEN LAG (TLPHN_LN_NUM) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM TLPHN_LN_NUM THEN 1  
                                                           WHEN LAG (OTHER_CRRR_SRVC_AREA_CD_LNGTH) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM OTHER_CRRR_SRVC_AREA_CD_LNGTH THEN 1  
                                                           WHEN LAG (OTHER_CRRR_CSTMR_STTS) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM OTHER_CRRR_CSTMR_STTS THEN 1  
                                                           WHEN LAG (OTHER_CRRR_ESTB_DT) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM OTHER_CRRR_ESTB_DT THEN 1  
                                                           WHEN LAG (OTHER_CRRR_CSTMR_DTBS_TIMESTAM) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM OTHER_CRRR_CSTMR_DTBS_TIMESTAM THEN 1  
                                                           WHEN LAG (DELTA_IND) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                               ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS DISTINCT FROM DELTA_IND THEN 1  
                                                    ELSE 0 END AS SDSMETA_IS_CHANGE  , CASE WHEN LAG (CRRR_ID) OVER (PARTITION BY CRRR_ID,EPAC,INVC_ARRNT_ID,TLPHN_LN_NUM 
                                                    ORDER BY effectivestartutcdttm,FileId,FileLineNumber) IS NULL THEN 1 ELSE 0 END AS SDSMETA_IS_FIRST
                                                from cte_T04035_CRRR_CSTMR_TABLE_Standardised keyed  ) cdc_flagged where SDSMETA_IS_CHANGE = 1  )  ,  
cte_T04035_CRRR_CSTMR_TABLE_denoised        AS (  select n.DELTA_SQNC_NUM,n.INVC_ARRNT_ID,n.CRRR_ID,n.EPAC,n.TLPHN_LN_NUM,n.OTHER_CRRR_SRVC_AREA_CD_LNGTH,n.OTHER_CRRR_CSTMR_STTS,n.OTHER_CRRR_ESTB_DT,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAM,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAMUTCDttm,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAMMLTDttm,n.DELTA_IND,n.effectivestartutcdttm, cast(NULL as timestamp) AS effectiveendutcdttm,n.fileid,n.filelinenumber,n.inserttaskid from cte_T04035_CRRR_CSTMR_TABLE_internaldenoise n LEFT OUTER JOIN cte_T04035_CRRR_CSTMR_TABLE_delta h ON (  h.effectiveendutcdttm = cast('9999-12-31 23:59:59' as timestamp) AND n.CRRR_ID=h.CRRR_ID AND n.EPAC=h.EPAC AND n.INVC_ARRNT_ID=h.INVC_ARRNT_ID AND n.TLPHN_LN_NUM=h.TLPHN_LN_NUM ) WHERE  ((  h. CRRR_ID is NULL  AND h. EPAC is NULL  AND h. INVC_ARRNT_ID is NULL  AND h. TLPHN_LN_NUM is NULL   AND h.fileid is null ) OR NOT ( n.DELTA_SQNC_NUM <=> h.DELTA_SQNC_NUM AND n.OTHER_CRRR_SRVC_AREA_CD_LNGTH <=> h.OTHER_CRRR_SRVC_AREA_CD_LNGTH AND n.OTHER_CRRR_CSTMR_STTS <=> h.OTHER_CRRR_CSTMR_STTS AND n.OTHER_CRRR_ESTB_DT <=> h.OTHER_CRRR_ESTB_DT AND n.OTHER_CRRR_CSTMR_DTBS_TIMESTAM <=> h.OTHER_CRRR_CSTMR_DTBS_TIMESTAM AND n.DELTA_IND <=> h.DELTA_IND   AND n.SDSMETA_IS_FIRST = 1 ))  ) ,
cte_T04035_CRRR_CSTMR_TABLE_affectedrecords AS (  select h.DELTA_SQNC_NUM,h.INVC_ARRNT_ID,h.CRRR_ID,h.EPAC,h.TLPHN_LN_NUM,h.OTHER_CRRR_SRVC_AREA_CD_LNGTH,h.OTHER_CRRR_CSTMR_STTS,h.OTHER_CRRR_ESTB_DT,h.OTHER_CRRR_CSTMR_DTBS_TIMESTAM,h.OTHER_CRRR_CSTMR_DTBS_TIMESTAMUTCDttm,h.OTHER_CRRR_CSTMR_DTBS_TIMESTAMMLTDttm,h.DELTA_IND,h.effectivestartutcdttm,h.effectiveendutcdttm,h.fileid,h.filelinenumber,h.inserttaskid,h.effectivestartutcdtprtnkey, true METADATA_EXISTING_RECORD from cte_T04035_CRRR_CSTMR_TABLE_delta h  LEFT SEMI JOIN cte_T04035_CRRR_CSTMR_TABLE_denoised n ON ( h.effectiveendutcdttm = cast('9999-12-31 23:59:59' as timestamp) AND h.CRRR_ID=n.CRRR_ID AND h.EPAC=n.EPAC AND h.INVC_ARRNT_ID=n.INVC_ARRNT_ID AND h.TLPHN_LN_NUM=n.TLPHN_LN_NUM )  UNION  ALL select n.DELTA_SQNC_NUM,n.INVC_ARRNT_ID,n.CRRR_ID,n.EPAC,n.TLPHN_LN_NUM,n.OTHER_CRRR_SRVC_AREA_CD_LNGTH,n.OTHER_CRRR_CSTMR_STTS,n.OTHER_CRRR_ESTB_DT,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAM,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAMUTCDttm,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAMMLTDttm,n.DELTA_IND,n.effectivestartutcdttm, cast(NULL as timestamp) effectiveendutcdttm ,n.fileid,n.filelinenumber,n.inserttaskid, CAST(REPLACE(TO_DATE(n.effectivestartutcdttm),'-','') AS INT) effectivestartutcdtprtnkey , false METADATA_EXISTING_RECORD  from cte_T04035_CRRR_CSTMR_TABLE_denoised n  ) ,
cte_T04035_CRRR_CSTMR_TABLE_stitchedrecords AS (   SELECT * FROM ( select n.DELTA_SQNC_NUM,n.INVC_ARRNT_ID,n.CRRR_ID,n.EPAC,n.TLPHN_LN_NUM,n.OTHER_CRRR_SRVC_AREA_CD_LNGTH,n.OTHER_CRRR_CSTMR_STTS,n.OTHER_CRRR_ESTB_DT,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAM,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAMUTCDttm,n.OTHER_CRRR_CSTMR_DTBS_TIMESTAMMLTDttm,n.DELTA_IND,n.effectivestartutcdttm, COALESCE( LEAD(effectivestartutcdttm - interval 1 second ) OVER (PARTITION BY  n.CRRR_ID,n.EPAC,n.INVC_ARRNT_ID,n.TLPHN_LN_NUM order by  n.effectivestartutcdttm, n.FileId, n.Filelinenumber  ),cast('9999-12-31 23:59:59' as timestamp) ) effectiveendutcdttm ,n.fileid,n.filelinenumber,n.inserttaskid,from_utc_timestamp(now(),'Australia/Melbourne') as publicationstartdttm,cast('9999-12-31 23:59:59' as timestamp) as publicationenddttm,n.effectivestartutcdtprtnkey, METADATA_EXISTING_RECORD from cte_T04035_CRRR_CSTMR_TABLE_affectedrecords n  WHERE 'I' NOT IN ('D') OR 'I' is NULL )   
													<bound method ChangeDataCapture.generate_sql_union_deletes of <patterns.changedatacapture.cdc_optimized.ChangeDataCapture object at 0x7f4ad0fdc280>>  
											   )   
SELECT * FROM cte_T04035_CRRR_CSTMR_TABLE_stitchedrecords  
                                        
