-- Use CTRL+Shift+M (in Management Studio 2012 or later) hotkey to fill required values

---------------------------------------------------------------------------------------

-- Deploy Info:            <Deploy notes (if any),,N/A>

---------------------------------------------------------------------------------------

SET NOCOUNT ON

 

DECLARE @app VARCHAR(128) ,

    @Version INT ,

    @Description [NVARCHAR](MAX) ,

    @MinorVersion INT,

       @Sprint VARCHAR(6),

       @Author NVARCHAR(250)

 

--##############################SET THE FOLLOWING VARIABLES FIRST######################################

SET @app = N'Wishlist'                              -- Related Application(Sales,Retail,etc)

SET @Version = 2                                -- Script version (101, 102, etc)

SET @Description = N''                    -- Set version Description

SET @MinorVersion = 0                       -- Set the MinorVersion (only for hotfixes)

SET @Sprint = N'<Sprint,,>'                                     -- Define sprint if any

SET @Author = N'<Author,,>'                                     -- Set script author

--#####################################################################################################

 

SET NOCOUNT ON

DECLARE @msg NVARCHAR(1024)

PRINT 'Begin transaction.'

BEGIN TRANSACTION;

BEGIN TRY

    PRINT 'Verify version.'

    IF NOT EXISTS ( SELECT  1

                    FROM    wishlist..DBScriptVersions

                    WHERE   [Version] = @Version and [MinorVersion] = @MinorVersion and [AppName] LIKE @app AND @Description LIKE [Description])

        BEGIN

                    IF EXISTS ( SELECT  1

                                        FROM    wishlist..DBScriptVersions

                                        WHERE   [Version] = @Version and [MinorVersion] = @MinorVersion and [AppName] LIKE @app AND @Description NOT LIKE [Description])

                                               RAISERROR('The version of this script might be wrong. Must be checked by it’s Vertical team.',11,1)

 

            IF @Version IS NULL OR @version=0

                   RAISERROR('Version is invalid or not defined',11,1)

 

            IF @Description IS NULL OR @Description LIKE ''

                   RAISERROR('Description is invalid or not defined',11,1)

 

            IF @app IS NULL OR @app LIKE ''

                   RAISERROR('Application Name is invalid or not defined',11,1)

 

            IF @author IS NULL OR @author LIKE ''

                   RAISERROR('Author is invalid or not defined',11,1)

 

           -- [Your script]​
			--inserir script do create table
 

            INSERT  INTO wishlist.[DBScriptVersions]

                    ( [Version],

                      [MinorVersion],

                      [Description],

                      [AppName],

                      [Sprint],

                      [Author]

                    )

 

            VALUES  ( @Version,

                      @MinorVersion,

                      @Description,

                      @app,

                    @Sprint,

                    @Author

                    )

 

        END        

       ELSE

             RAISERROR('This script already was executed in this database.',10,1)

 

   PRINT 'Commit transaction.'

   COMMIT TRANSACTION

END TRY

BEGIN CATCH

    SET @msg=ERROR_MESSAGE()

    ROLLBACK TRAN

    RAISERROR(@msg,11,1)

END CATCH

 

SET NOCOUNT OFF​