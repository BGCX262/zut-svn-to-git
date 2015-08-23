<?xml version="1.0" encoding="UTF-8"?>
<?PowerDesigner AppLocale="UTF16" ID="{3BE49602-24B6-430B-92A5-8A074E13C7EF}" Label="" LastModificationDate="1358353738" Name="model" Objects="66" Symbols="37" Target="Java 1.x" TargetLink="Reference" Type="{18112060-1A4B-11D1-83D9-444553540000}" signature="CLD_OBJECT_MODEL" version="15.1.0.2850"?>
<!-- Veuillez ne pas modifier ce fichier -->

<Model xmlns:a="attribute" xmlns:c="collection" xmlns:o="object">

<o:RootObject Id="o1">
<c:Children>
<o:Model Id="o2">
<a:ObjectID>3BE49602-24B6-430B-92A5-8A074E13C7EF</a:ObjectID>
<a:Name>model</a:Name>
<a:Code>model</a:Code>
<a:CreationDate>1358254726</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353702</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:PackageOptionsText>[FolderOptions]

[FolderOptions\Class Diagram Objects]
GenerationCheckModel=Yes
GenerationPath=
GenerationOptions=
GenerationTasks=
GenerationTargets=
GenerationSelections=</a:PackageOptionsText>
<a:ModelOptionsText>[ModelOptions]

[ModelOptions\Cld]
CaseSensitive=Yes
DisplayName=Yes
EnableTrans=Yes
EnableRequirements=No
ShowClss=No
DeftAttr=int
DeftMthd=int
DeftParm=int
DeftCont=java.util.Collection
DomnDttp=Yes
DomnChck=No
DomnRule=No
SupportDelay=No
PreviewEditable=Yes
AutoRealize=No
DttpFullName=Yes
DeftClssAttrVisi=private
VBNetPreprocessingSymbols=
CSharpPreprocessingSymbols=

[ModelOptions\Cld\NamingOptionsTemplates]

[ModelOptions\Cld\ClssNamingOptions]

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG]

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN]

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS]

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDINTF]

[ModelOptions\Cld\ClssNamingOptions\CLDINTF\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDINTF\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDACTR]

[ModelOptions\Cld\ClssNamingOptions\UCDACTR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDACTR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS]

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT]

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG]

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP]

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDATTR]

[ModelOptions\Cld\ClssNamingOptions\CLDATTR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDATTR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD]

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPARM]

[ModelOptions\Cld\ClssNamingOptions\CLDPARM\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPARM\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPORT]

[ModelOptions\Cld\ClssNamingOptions\OOMPORT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPORT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPART]

[ModelOptions\Cld\ClssNamingOptions\OOMPART\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPART\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDASSC]

[ModelOptions\Cld\ClssNamingOptions\CLDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDASSC]

[ModelOptions\Cld\ClssNamingOptions\UCDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK]

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RQLINK]

[ModelOptions\Cld\ClssNamingOptions\RQLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RQLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK]

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK]

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMACTV]

[ModelOptions\Cld\ClssNamingOptions\OOMACTV\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMACTV\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\ACDOBST]

[ModelOptions\Cld\ClssNamingOptions\ACDOBST\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\ACDOBST\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\STAT]

[ModelOptions\Cld\ClssNamingOptions\STAT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\STAT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDNODE]

[ModelOptions\Cld\ClssNamingOptions\DPDNODE\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDNODE\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI]

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDASSC]

[ModelOptions\Cld\ClssNamingOptions\DPDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMVAR]

[ModelOptions\Cld\ClssNamingOptions\OOMVAR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMVAR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FILO]

[ModelOptions\Cld\ClssNamingOptions\FILO\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=&quot;\/:*?&lt;&gt;|&quot;
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FILO\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_. &quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ]

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMELNK]

[ModelOptions\Cld\ClssNamingOptions\FRMELNK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMELNK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DefaultClass]

[ModelOptions\Cld\ClssNamingOptions\DefaultClass\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DefaultClass\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Generate]

[ModelOptions\Generate\Cdm]
CheckModel=Yes
SaveLinks=Yes
NameToCode=No
Notation=2

[ModelOptions\Generate\Pdm]
CheckModel=Yes
SaveLinks=Yes
ORMapping=No
NameToCode=No
BuildTrgr=No
TablePrefix=
RefrUpdRule=RESTRICT
RefrDelRule=RESTRICT
IndxPKName=%TABLE%_PK
IndxAKName=%TABLE%_AK
IndxFKName=%REFR%_FK
IndxThreshold=
ColnFKName=%.3:PARENT%_%COLUMN%
ColnFKNameUse=No

[ModelOptions\Generate\Xsm]
CheckModel=Yes
SaveLinks=Yes
ORMapping=No
NameToCode=No</a:ModelOptionsText>
<c:ObjectLanguage>
<o:Shortcut Id="o3">
<a:ObjectID>BA7959AC-FCB3-4841-AAE0-46C863855899</a:ObjectID>
<a:Name>Java 1.x</a:Name>
<a:Code>Java</a:Code>
<a:CreationDate>1358254874</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358254874</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>D824A738-E160-11D2-B693-0008C7EA924D</a:TargetID>
<a:TargetClassID>1811206C-1A4B-11D1-83D9-444553540000</a:TargetClassID>
</o:Shortcut>
</c:ObjectLanguage>
<c:ExtendedModelDefinitions>
<o:Shortcut Id="o4">
<a:ObjectID>3EBEF648-27F4-4FCA-B6B7-C98DA2A963E7</a:ObjectID>
<a:Name>WSDL for Java</a:Name>
<a:Code>WSDLJava</a:Code>
<a:CreationDate>1358254874</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358254874</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>C8F5F7B2-CF9D-4E98-8301-959BB6E86C8A</a:TargetID>
<a:TargetClassID>186C8AC3-D3DC-11D3-881C-00508B03C75C</a:TargetClassID>
</o:Shortcut>
</c:ExtendedModelDefinitions>
<c:ClassDiagrams>
<o:ClassDiagram Id="o5">
<a:ObjectID>F3B25F13-1850-437C-8E96-384EB78CCABC</a:ObjectID>
<a:Name>DiagrammeClasses_1</a:Name>
<a:Code>DiagrammeClasses_1</a:Code>
<a:CreationDate>1358254726</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353702</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DisplayPreferences>[DisplayPreferences]

[DisplayPreferences\CLD]

[DisplayPreferences\General]
Adjust to text=Yes
Snap Grid=No
Constrain Labels=Yes
Display Grid=No
Show Page Delimiter=Yes
Grid size=0
Graphic unit=2
Window color=255, 255, 255
Background image=
Background mode=8
Watermark image=
Watermark mode=8
Show watermark on screen=No
Gradient mode=0
Gradient end color=255, 255, 255
Show Swimlane=No
SwimlaneVert=Yes
TreeVert=No
CompDark=0

[DisplayPreferences\Object]
Mode=0
Trunc Length=80
Word Length=80
Word Text=!&quot;&quot;#$%&amp;&#39;()*+,-./:;&lt;=&gt;?@[\]^_`{|}~
Shortcut IntIcon=Yes
Shortcut IntLoct=Yes
Shortcut IntFullPath=No
Shortcut IntLastPackage=Yes
Shortcut ExtIcon=Yes
Shortcut ExtLoct=No
Shortcut ExtFullPath=No
Shortcut ExtLastPackage=Yes
Shortcut ExtIncludeModl=Yes
EObjShowStrn=Yes
ExtendedObject.Comment=No
ExtendedObject.IconPicture=No
ExtendedObject_SymbolLayout=
ELnkShowStrn=Yes
ELnkShowName=Yes
ExtendedLink_SymbolLayout=
FileObject.Stereotype=No
FileObject.DisplayName=Yes
FileObject.LocationOrName=No
FileObject.IconPicture=No
FileObject.IconMode=Yes
FileObject_SymbolLayout=
PckgShowStrn=Yes
Package.Comment=No
Package.IconPicture=No
Package_SymbolLayout=
Display Model Version=Yes
Class.IconPicture=No
Class_SymbolLayout=
Interface.IconPicture=No
Interface_SymbolLayout=
Port.IconPicture=No
Port_SymbolLayout=
ClssShowSttr=Yes
Class.Comment=No
ClssShowCntr=Yes
ClssShowAttr=Yes
ClssAttrTrun=No
ClssAttrMax=3
ClssShowMthd=Yes
ClssMthdTrun=No
ClssMthdMax=3
ClssShowInnr=Yes
IntfShowSttr=Yes
Interface.Comment=No
IntfShowAttr=Yes
IntfAttrTrun=No
IntfAttrMax=3
IntfShowMthd=Yes
IntfMthdTrun=No
IntfMthdMax=3
IntfShowCntr=Yes
IntfShowInnr=Yes
PortShowName=Yes
PortShowType=No
PortShowMult=No
AttrShowVisi=Yes
AttrVisiFmt=1
AttrShowStrn=Yes
AttrShowDttp=Yes
AttrShowDomn=No
AttrShowInit=Yes
MthdShowVisi=Yes
MthdVisiFmt=1
MthdShowStrn=Yes
MthdShowRttp=Yes
MthdShowParm=Yes
AsscShowName=No
AsscShowCntr=Yes
AsscShowRole=Yes
AsscShowOrdr=Yes
AsscShowMult=Yes
AsscMultStr=Yes
AsscShowStrn=No
GnrlShowName=No
GnrlShowStrn=Yes
GnrlShowCntr=Yes
RlzsShowName=No
RlzsShowStrn=Yes
RlzsShowCntr=Yes
DepdShowName=No
DepdShowStrn=Yes
DepdShowCntr=Yes
RqlkShowName=No
RqlkShowStrn=Yes
RqlkShowCntr=Yes

[DisplayPreferences\Symbol]

[DisplayPreferences\Symbol\FRMEOBJ]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=6000
Height=2000
Brush color=255 255 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=64
Brush gradient color=192 192 192
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 255 128 128
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\FRMELNK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=2
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\FILO]
OBJSTRNFont=Arial,8,N
OBJSTRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LCNMFont=Arial,8,N
LCNMFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=Yes
Keep center=Yes
Keep size=No
Width=2400
Height=2400
Brush color=255 255 255
Fill Color=No
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 0 255
Shadow color=192 192 192
Shadow=-1

[DisplayPreferences\Symbol\CLDPCKG]
STRNFont=Arial,8,N
STRNFont color=0 0 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
LABLFont=Arial,8,N
LABLFont color=0 0 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 178 178 178
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDCLASS]
STRNFont=Arial,8,N
STRNFont color=0 0 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
CNTRFont=Arial,8,N
CNTRFont color=0 0 0
AttributesFont=Arial,8,N
AttributesFont color=0 0 0
ClassPrimaryAttributeFont=Arial,8,U
ClassPrimaryAttributeFont color=0 0 0
OperationsFont=Arial,8,N
OperationsFont color=0 0 0
InnerClassifiersFont=Arial,8,N
InnerClassifiersFont color=0 0 0
LABLFont=Arial,8,N
LABLFont color=0 0 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=233 202 131
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 0 0
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDINTF]
STRNFont=Arial,8,N
STRNFont color=0 0 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
CNTRFont=Arial,8,N
CNTRFont color=0 0 0
AttributesFont=Arial,8,N
AttributesFont color=0 0 0
OperationsFont=Arial,8,N
OperationsFont color=0 0 0
InnerClassifiersFont=Arial,8,N
InnerClassifiersFont color=0 0 0
LABLFont=Arial,8,N
LABLFont color=0 0 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=205 156 156
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 0 0
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\OOMPORT]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
AutoAdjustToText=No
Keep aspect=No
Keep center=No
Keep size=No
Width=825
Height=800
Brush color=250 241 211
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 64 0
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDASSC]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
MULAFont=Arial,8,N
MULAFont color=0 0 0
Line style=2
Pen=1 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\INNERLINK]
Line style=2
Pen=1 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDACLK]
Line style=2
Pen=2 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\GNRLLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
Line style=2
Pen=1 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RLZSLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
Line style=2
Pen=3 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RQLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
Line style=2
Pen=1 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\DEPDLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0 0 0
Line style=2
Pen=2 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\USRDEPD]
OBJXSTRFont=Arial,8,N
OBJXSTRFont color=0 0 0
Line style=2
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=2 0 128 0 64
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\Free Symbol]
Free TextFont=Arial,8,N
Free TextFont color=0 0 0
Line style=2
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 64 0
Shadow color=192 192 192
Shadow=0</a:DisplayPreferences>
<a:PaperSize>(8268, 11693)</a:PaperSize>
<a:PageMargins>((315,354), (433,354))</a:PageMargins>
<a:PageOrientation>1</a:PageOrientation>
<a:PaperSource>15</a:PaperSource>
<c:Symbols>
<o:AssociationSymbol Id="o6">
<a:CreationDate>1358258581</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-10199,-34957), (-2648,-17346))</a:Rect>
<a:ListOfPoints>((-4635,-17346),(-4635,-25925),(-8212,-25925),(-8212,-34957))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o7"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o8"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o9"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o10">
<a:CreationDate>1358258607</a:CreationDate>
<a:ModificationDate>1358260902</a:ModificationDate>
<a:Rect>((-13756,-17534), (-8444,27915))</a:Rect>
<a:ListOfPoints>((-13719,27915),(-13719,4202),(-8481,4202),(-8481,-17534))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o11"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o7"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o12"/>
</c:Object>
</o:AssociationSymbol>
<o:GeneralizationSymbol Id="o13">
<a:CreationDate>1358258610</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-16523,-18031), (-8480,-1296))</a:Rect>
<a:ListOfPoints>((-8480,-18031),(-16523,-18031),(-16523,-1296))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o7"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o14"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o15"/>
</c:Object>
</o:GeneralizationSymbol>
<o:AssociationSymbol Id="o16">
<a:CreationDate>1358258713</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-40631,-17628), (-8969,-1613))</a:Rect>
<a:ListOfPoints>((-9006,-17628),(-9006,-2788),(-40631,-2788))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o7"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o17"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o18"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o19">
<a:CreationDate>1358258788</a:CreationDate>
<a:ModificationDate>1358260946</a:ModificationDate>
<a:Rect>((-48592,-19723), (-9032,24915))</a:Rect>
<a:ListOfPoints>((-46605,-19723),(-46605,21041),(-11769,21041),(-11769,24915))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o20"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o11"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o21"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o22">
<a:CreationDate>1358258790</a:CreationDate>
<a:ModificationDate>1358260986</a:ModificationDate>
<a:Rect>((-10526,-3272), (23452,25764))</a:Rect>
<a:ListOfPoints>((23415,-3272),(23415,24690),(-10526,24690))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o23"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o11"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o24"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o25">
<a:CreationDate>1358258798</a:CreationDate>
<a:ModificationDate>1358260975</a:ModificationDate>
<a:Rect>((-42219,-22571), (12885,-16945))</a:Rect>
<a:ListOfPoints>((-42219,-22571),(11023,-22571),(11185,-16945))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o20"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o26"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o27"/>
</c:Object>
</o:AssociationSymbol>
<o:GeneralizationSymbol Id="o28">
<a:CreationDate>1358258848</a:CreationDate>
<a:ModificationDate>1358260979</a:ModificationDate>
<a:Rect>((-44686,-19823), (-16523,-1690))</a:Rect>
<a:ListOfPoints>((-44686,-19823),(-16523,-19823),(-16523,-1690))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o20"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o14"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o29"/>
</c:Object>
</o:GeneralizationSymbol>
<o:AssociationSymbol Id="o30">
<a:CreationDate>1358259006</a:CreationDate>
<a:ModificationDate>1358260986</a:ModificationDate>
<a:Rect>((-44879,-21359), (22810,-3720))</a:Rect>
<a:ListOfPoints>((20823,-3720),(20823,-21359),(-44879,-21359))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o23"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o20"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o31"/>
</c:Object>
</o:AssociationSymbol>
<o:GeneralizationSymbol Id="o32">
<a:CreationDate>1358259066</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((1310,-640), (34424,16630))</a:Rect>
<a:ListOfPoints>((1310,-640),(1310,16630),(34424,16630))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o33"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o34"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o35"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o36">
<a:CreationDate>1358259129</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-16523,-17533), (8274,-1690))</a:Rect>
<a:ListOfPoints>((8274,-17533),(8274,-1690),(-16523,-1690))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o26"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o14"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o37"/>
</c:Object>
</o:GeneralizationSymbol>
<o:AssociationSymbol Id="o38">
<a:CreationDate>1358259346</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-22574,-763), (6225,4311))</a:Rect>
<a:ListOfPoints>((1238,411),(-22574,411),(-22574,4311),(6188,4311),(6188,261))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o33"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o33"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o39"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o40">
<a:CreationDate>1358259444</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((3151,-2214), (11888,20997))</a:Rect>
<a:ListOfPoints>((6938,-2214),(11888,-2214),(11888,20997),(6338,20997),(6338,786))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o33"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o33"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o41"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o42">
<a:CreationDate>1358259491</a:CreationDate>
<a:ModificationDate>1358260911</a:ModificationDate>
<a:Rect>((-4494,-641), (2759,25314))</a:Rect>
<a:ListOfPoints>((1312,-641),(1312,24240),(-4494,24240))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o33"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o11"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o43"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o44">
<a:CreationDate>1358259542</a:CreationDate>
<a:ModificationDate>1358260986</a:ModificationDate>
<a:Rect>((-3674,-5411), (27464,-1523))</a:Rect>
<a:ListOfPoints>((-3637,-1523),(-3637,-4336),(27464,-4336))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o33"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o23"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o45"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o46">
<a:CreationDate>1358353594</a:CreationDate>
<a:ModificationDate>1358353594</a:ModificationDate>
<a:Rect>((-43949,-17850), (19875,-3074))</a:Rect>
<a:ListOfPoints>((-41925,-17850),(-41925,-3075),(19875,-3075))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o20"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o23"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o47"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o48">
<a:CreationDate>1358353702</a:CreationDate>
<a:ModificationDate>1358353702</a:ModificationDate>
<a:Rect>((-43500,-20110), (3483,-17762))</a:Rect>
<a:ListOfPoints>((3483,-18937),(-43500,-18937))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o26"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o20"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o49"/>
</c:Object>
</o:AssociationSymbol>
<o:NoteSymbol Id="o50">
<a:Text>- Definir les accesseurs pour tous les attributs d&#39;entite
- Pour les emails, on utilisera des template par le biais de Spring velocity.
</a:Text>
<a:CreationDate>1358255552</a:CreationDate>
<a:ModificationDate>1358259822</a:ModificationDate>
<a:Rect>((-23266,37909), (-3600,34309))</a:Rect>
<a:TextStyle>4130</a:TextStyle>
<a:AutoAdjustToText>0</a:AutoAdjustToText>
<a:LineColor>16512</a:LineColor>
<a:FillColor>16777215</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontName>Arial,8,N</a:FontName>
<a:ManuallyResized>1</a:ManuallyResized>
</o:NoteSymbol>
<o:GeneralizationSymbol Id="o51">
<a:CreationDate>1358255162</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-16523,-1691), (34424,16631))</a:Rect>
<a:ListOfPoints>((34424,16631),(34424,-1691),(-16523,-1691))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o34"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o14"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o52"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o53">
<a:CreationDate>1358255519</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-34822,-1129), (34424,16631))</a:Rect>
<a:ListOfPoints>((-34822,-1129),(-34822,16631),(34424,16631))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o17"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o34"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o54"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o55">
<a:CreationDate>1358255749</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((34424,15887), (51603,16887))</a:Rect>
<a:ListOfPoints>((51603,16387),(34424,16387))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o56"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o34"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o57"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o58">
<a:CreationDate>1358255826</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-8435,16631), (34424,26424))</a:Rect>
<a:ListOfPoints>((-8435,26424),(-8435,16631),(34424,16631))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o11"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o34"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o59"/>
</c:Object>
</o:GeneralizationSymbol>
<o:AssociationSymbol Id="o60">
<a:CreationDate>1358255871</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-8472,14969), (53603,24424))</a:Rect>
<a:ListOfPoints>((-8435,24424),(-8435,16143),(53603,16143))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o11"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o56"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o61"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o62">
<a:CreationDate>1358255900</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:Rect>((-8435,16143), (51640,27598))</a:Rect>
<a:ListOfPoints>((51603,16143),(51603,26424),(-8435,26424))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o56"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o11"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o63"/>
</c:Object>
</o:AssociationSymbol>
<o:AssociationSymbol Id="o64">
<a:CreationDate>1358256125</a:CreationDate>
<a:ModificationDate>1358260918</a:ModificationDate>
<a:Rect>((-34821,-1128), (-6448,26425))</a:Rect>
<a:ListOfPoints>((-8435,26425),(-8435,-1128),(-34821,-1128))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>3592</a:ArrowStyle>
<a:LineColor>4194432</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N
MULA 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o11"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o17"/>
</c:DestinationSymbol>
<c:Object>
<o:Association Ref="o65"/>
</c:Object>
</o:AssociationSymbol>
<o:ClassSymbol Id="o17">
<a:CreationDate>1358254778</a:CreationDate>
<a:ModificationDate>1358260918</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-41527,-4012), (-28115,1756))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o66"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o56">
<a:CreationDate>1358254778</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((45359,13747), (57845,18541))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o67"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o11">
<a:CreationDate>1358254781</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-14717,23541), (-2153,29309))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o68"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o14">
<a:CreationDate>1358254938</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-23114,-5136), (-9932,1756))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o69"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o34">
<a:CreationDate>1358254939</a:CreationDate>
<a:ModificationDate>1358260207</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((28490,14720), (40358,18541))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o70"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o33">
<a:CreationDate>1358258508</a:CreationDate>
<a:ModificationDate>1358260911</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-4931,-3038), (7555,1756))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o71"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o26">
<a:CreationDate>1358258508</a:CreationDate>
<a:ModificationDate>1358260936</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((2029,-19931), (14515,-15137))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o72"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o23">
<a:CreationDate>1358258508</a:CreationDate>
<a:ModificationDate>1358260986</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((17365,-5669), (29465,-875))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o73"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o20">
<a:CreationDate>1358258509</a:CreationDate>
<a:ModificationDate>1358260952</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-52454,-24582), (-40756,-14864))</a:Rect>
<a:AutoAdjustToText>0</a:AutoAdjustToText>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<a:ManuallyResized>1</a:ManuallyResized>
<c:Object>
<o:Class Ref="o74"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o7">
<a:CreationDate>1358258512</a:CreationDate>
<a:ModificationDate>1358260902</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-14338,-19931), (-2624,-15137))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>8637161</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o75"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o8">
<a:CreationDate>1358258512</a:CreationDate>
<a:ModificationDate>1358260092</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-15296,-37840), (-1574,-31922))</a:Rect>
<a:LineColor>128</a:LineColor>
<a:FillColor>16744448</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o76"/>
</c:Object>
</o:ClassSymbol>
</c:Symbols>
</o:ClassDiagram>
</c:ClassDiagrams>
<c:DefaultDiagram>
<o:ClassDiagram Ref="o5"/>
</c:DefaultDiagram>
<c:Classes>
<o:Class Id="o66">
<a:ObjectID>D89AB663-ADAA-44C8-A7D1-9681D2DEADB1</a:ObjectID>
<a:Name>User</a:Name>
<a:Code>User</a:Code>
<a:CreationDate>1358254778</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258723</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o77">
<a:ObjectID>2213A6D9-9679-40D5-9104-96E4D357A6D0</a:ObjectID>
<a:Name>username</a:Name>
<a:Code>username</a:Code>
<a:CreationDate>1358255442</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255501</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o78">
<a:ObjectID>FC8536AA-F729-4169-ADDD-225D2FB7F9B2</a:ObjectID>
<a:Name>primaryEmail</a:Name>
<a:Code>primaryEmail</a:Code>
<a:CreationDate>1358255442</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255501</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o79">
<a:ObjectID>4211D070-98E0-42EE-9E1C-83B005E344BE</a:ObjectID>
<a:Name>password</a:Name>
<a:Code>password</a:Code>
<a:CreationDate>1358255442</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255501</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o67">
<a:ObjectID>505A6D70-DB6C-4EC9-9135-B44A215C05B8</a:ObjectID>
<a:Name>Role</a:Name>
<a:Code>role</a:Code>
<a:CreationDate>1358254778</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255986</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o80">
<a:ObjectID>E3D386A5-1541-44C5-833E-2A15159BC001</a:ObjectID>
<a:Name>name</a:Name>
<a:Code>name</a:Code>
<a:CreationDate>1358255678</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255735</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o81">
<a:ObjectID>76A08EC1-0ECA-4185-9DC4-8F58FB24CC5B</a:ObjectID>
<a:Name>description</a:Name>
<a:Code>description</a:Code>
<a:CreationDate>1358255678</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255735</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o68">
<a:ObjectID>F19B3832-1A5C-4273-89C7-836E91865F0A</a:ObjectID>
<a:Name>Account</a:Name>
<a:Code>Account</a:Code>
<a:CreationDate>1358254781</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259742</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o82">
<a:ObjectID>ABC13891-E561-4E19-801E-818A4EEDA7DA</a:ObjectID>
<a:Name>disabled</a:Name>
<a:Code>disabled</a:Code>
<a:CreationDate>1358256213</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358256291</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.Boolean</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o83">
<a:ObjectID>20C77EF1-DA05-4C65-963D-098BF0B7C37E</a:ObjectID>
<a:Name>loacked</a:Name>
<a:Code>loacked</a:Code>
<a:CreationDate>1358256213</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358256291</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.Boolean</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o84">
<a:ObjectID>894AB163-896B-44A3-9F39-2F95B24DF73B</a:ObjectID>
<a:Name>expired</a:Name>
<a:Code>expired</a:Code>
<a:CreationDate>1358256213</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358256291</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.Boolean</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o69">
<a:ObjectID>B791ABF0-D807-459A-9668-E0D4B72B899F</a:ObjectID>
<a:Name>BaseEntity</a:Name>
<a:Code>BaseEntity</a:Code>
<a:CreationDate>1358254938</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259140</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<a:Classifier.Abstract>1</a:Classifier.Abstract>
<c:Attributes>
<o:Attribute Id="o85">
<a:ObjectID>D16298D4-5380-4176-9BFD-D14A33E3DE2C</a:ObjectID>
<a:Name>id</a:Name>
<a:Code>id</a:Code>
<a:CreationDate>1358255200</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255284</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>int</a:DataType>
<a:Attribute.Visibility>#</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o86">
<a:ObjectID>04482192-BBEF-4323-B1D5-5D884DEEB99C</a:ObjectID>
<a:Name>createdAt</a:Name>
<a:Code>createdAt</a:Code>
<a:CreationDate>1358255200</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255284</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.util.Date</a:DataType>
<a:Attribute.Visibility>#</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o87">
<a:ObjectID>8E252D82-06AF-4A8B-AC20-DCF930C53F8D</a:ObjectID>
<a:Name>deleted</a:Name>
<a:Code>deleted</a:Code>
<a:CreationDate>1358255200</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255284</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.Boolean</a:DataType>
<a:Attribute.Visibility>#</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o70">
<a:ObjectID>144AB744-6D1C-48A0-9B81-CE0D063A7F27</a:ObjectID>
<a:Name>EditableEntity</a:Name>
<a:Code>EditableEntity</a:Code>
<a:CreationDate>1358254939</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259097</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o88">
<a:ObjectID>769F2775-D140-4965-AFBC-2BBF06144E63</a:ObjectID>
<a:Name>modifiedAt</a:Name>
<a:Code>modifiedAt</a:Code>
<a:CreationDate>1358255298</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255361</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.util.Date</a:DataType>
<a:Attribute.Visibility>#</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o71">
<a:ObjectID>B17123D9-411C-4CE4-8BB1-2123C07AFA70</a:ObjectID>
<a:Name>Tag</a:Name>
<a:Code>Tag</a:Code>
<a:CreationDate>1358258508</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259556</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o89">
<a:ObjectID>054A289D-033A-4B84-B35C-DD3C0C86B86B</a:ObjectID>
<a:Name>name</a:Name>
<a:Code>name</a:Code>
<a:CreationDate>1358259066</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358344438</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o90">
<a:ObjectID>C05E60F3-6FD6-41B1-9A07-43685DA5461F</a:ObjectID>
<a:Name>description</a:Name>
<a:Code>description</a:Code>
<a:CreationDate>1358259066</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259097</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o72">
<a:ObjectID>9CD126DD-C54B-4D5F-BD64-EAAEA0CB0C4A</a:ObjectID>
<a:Name>Attachment</a:Name>
<a:Code>Attachment</a:Code>
<a:CreationDate>1358258508</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353714</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o91">
<a:ObjectID>F615CFA1-8BBA-40C1-BEA6-B4A12F91B843</a:ObjectID>
<a:Name>filename</a:Name>
<a:Code>filename</a:Code>
<a:CreationDate>1358259686</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259707</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o92">
<a:ObjectID>CE89A0BF-4367-4C77-BA92-3E36381DEA9B</a:ObjectID>
<a:Name>description</a:Name>
<a:Code>description</a:Code>
<a:CreationDate>1358259686</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353738</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o73">
<a:ObjectID>CF9C45D6-3F28-4FDB-B517-D8FF134E8323</a:ObjectID>
<a:Name>Thread</a:Name>
<a:Code>Thread</a:Code>
<a:CreationDate>1358258508</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353609</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o93">
<a:ObjectID>9E48363F-891D-425D-88C0-D352FC7AE406</a:ObjectID>
<a:Name>title</a:Name>
<a:Code>title</a:Code>
<a:CreationDate>1358258823</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259117</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o94">
<a:ObjectID>A7F16F5E-4332-4F6C-995E-F48DF9026420</a:ObjectID>
<a:Name>actived</a:Name>
<a:Code>actived</a:Code>
<a:CreationDate>1358258823</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259117</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.Boolean</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o74">
<a:ObjectID>425ED297-94BD-43DD-B0B9-9CD116FB7DA2</a:ObjectID>
<a:Name>Post</a:Name>
<a:Code>Post</a:Code>
<a:CreationDate>1358258509</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353714</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o95">
<a:ObjectID>732AA880-347C-44C4-AAC2-418AFCC5E564</a:ObjectID>
<a:Name>content</a:Name>
<a:Code>content</a:Code>
<a:CreationDate>1358258929</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259104</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o96">
<a:ObjectID>8F9BFD90-2D59-4F9D-B6AD-CB4FBAE5D35A</a:ObjectID>
<a:Name>actived</a:Name>
<a:Code>actived</a:Code>
<a:CreationDate>1358258929</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259575</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o75">
<a:ObjectID>7F93FB69-AF1D-47B7-AF51-688A8E1D3549</a:ObjectID>
<a:Name>SendHistoric</a:Name>
<a:Code>SendHistoric</a:Code>
<a:CreationDate>1358258512</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259646</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o97">
<a:ObjectID>7D0DA735-6EB6-4AAC-87DB-1F053B9894D9</a:ObjectID>
<a:Name>recipient</a:Name>
<a:Code>recipient</a:Code>
<a:CreationDate>1358259594</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259646</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o98">
<a:ObjectID>051C2BC9-CB87-44B3-8FB5-E4E24B8EA77D</a:ObjectID>
<a:Name>sender</a:Name>
<a:Code>sender</a:Code>
<a:CreationDate>1358259594</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259646</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o76">
<a:ObjectID>FB9FC93B-F9DD-47FC-92FA-D5EF451C13EF</a:ObjectID>
<a:Name>EmailType</a:Name>
<a:Code>EmailType</a:Code>
<a:CreationDate>1358258512</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258673</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:Stereotype>Enum</a:Stereotype>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o99">
<a:ObjectID>711F4CD5-71EF-4271-8114-216E0251F2F8</a:ObjectID>
<a:Name>registration</a:Name>
<a:Code>registration</a:Code>
<a:CreationDate>1358258550</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258572</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>EnumConstant</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o100">
<a:ObjectID>8778E92F-D9E5-46FD-A694-9B516E0A2553</a:ObjectID>
<a:Name>postNotification</a:Name>
<a:Code>postNotification</a:Code>
<a:CreationDate>1358258550</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258572</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:DataType>EnumConstant</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
</c:Classes>
<c:Associations>
<o:Association Id="o61">
<a:ObjectID>9DE6AEBD-4F52-4519-AF59-2983BDD70724</a:ObjectID>
<a:Name>Association_1</a:Name>
<a:Code>association1</a:Code>
<a:CreationDate>1358255871</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255947</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o67"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o68"/>
</c:Object2>
</o:Association>
<o:Association Id="o63">
<a:ObjectID>43FC8C37-15CC-4B33-9AEC-CDC72CF925E9</a:ObjectID>
<a:Name>Association_2</a:Name>
<a:Code>association2</a:Code>
<a:CreationDate>1358255900</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255986</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o68"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o67"/>
</c:Object2>
</o:Association>
<o:Association Id="o65">
<a:ObjectID>DB3BE595-8CE5-4566-8F35-C32BC4F365DB</a:ObjectID>
<a:Name>Association_3</a:Name>
<a:Code>association3</a:Code>
<a:CreationDate>1358256125</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358256145</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o66"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o68"/>
</c:Object2>
</o:Association>
<o:Association Id="o9">
<a:ObjectID>B129F5BF-1F71-47FD-A26C-0419A90E68F7</a:ObjectID>
<a:Name>Association_4</a:Name>
<a:Code>association4</a:Code>
<a:CreationDate>1358258581</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258673</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o76"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o75"/>
</c:Object2>
</o:Association>
<o:Association Id="o12">
<a:ObjectID>4660C50C-7D43-4098-91B1-C9444EC0B2E9</a:ObjectID>
<a:Name>Association_5</a:Name>
<a:Code>association5</a:Code>
<a:CreationDate>1358258607</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258633</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o75"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o68"/>
</c:Object2>
</o:Association>
<o:Association Id="o18">
<a:ObjectID>57482AA6-4C4B-4134-91A8-C7C262745FF4</a:ObjectID>
<a:Name>Association_6</a:Name>
<a:Code>association6</a:Code>
<a:CreationDate>1358258713</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258723</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o66"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o75"/>
</c:Object2>
</o:Association>
<o:Association Id="o21">
<a:ObjectID>451B1EA6-BF5A-4D80-8BF2-85DAC1089331</a:ObjectID>
<a:Name>Association_7</a:Name>
<a:Code>association7</a:Code>
<a:CreationDate>1358258788</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259324</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBName>owner</a:RoleBName>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o68"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o74"/>
</c:Object2>
</o:Association>
<o:Association Id="o24">
<a:ObjectID>DF3D8878-451D-4AD9-A470-5FEE7CC345D0</a:ObjectID>
<a:Name>Association_8</a:Name>
<a:Code>association8</a:Code>
<a:CreationDate>1358258790</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258820</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBName>owner</a:RoleBName>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o68"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o73"/>
</c:Object2>
</o:Association>
<o:Association Id="o27">
<a:ObjectID>87ED95A6-F7A8-45D9-8709-670C6FD89184</a:ObjectID>
<a:Name>Association_9</a:Name>
<a:Code>association9</a:Code>
<a:CreationDate>1358258798</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258912</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o72"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o74"/>
</c:Object2>
</o:Association>
<o:Association Id="o31">
<a:ObjectID>C6FC6BFB-2796-4CBC-A756-4144BDC7509D</a:ObjectID>
<a:Name>Association_10</a:Name>
<a:Code>association10</a:Code>
<a:CreationDate>1358259006</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259028</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o74"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o73"/>
</c:Object2>
</o:Association>
<o:Association Id="o39">
<a:ObjectID>95692195-66C0-4D4D-BD1B-A5C7B236DF91</a:ObjectID>
<a:Name>Association_12</a:Name>
<a:Code>association12</a:Code>
<a:CreationDate>1358259346</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259423</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBName>children</a:RoleBName>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o71"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o71"/>
</c:Object2>
</o:Association>
<o:Association Id="o41">
<a:ObjectID>49A1112B-DF65-4812-8BF4-BE40D72AFBE2</a:ObjectID>
<a:Name>Association_13</a:Name>
<a:Code>association13</a:Code>
<a:CreationDate>1358259445</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259465</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBName>parents</a:RoleBName>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o71"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o71"/>
</c:Object2>
</o:Association>
<o:Association Id="o43">
<a:ObjectID>1F82C61A-6625-4CC7-BE97-F1EF8BE2DDAA</a:ObjectID>
<a:Name>Association_14</a:Name>
<a:Code>association14</a:Code>
<a:CreationDate>1358259491</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259507</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBName>accounts</a:RoleBName>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,296={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,13=java.util.Set

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o68"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o71"/>
</c:Object2>
</o:Association>
<o:Association Id="o45">
<a:ObjectID>5A30CB2F-78F3-4DE2-89D3-12DE36D1A352</a:ObjectID>
<a:Name>Association_15</a:Name>
<a:Code>association15</a:Code>
<a:CreationDate>1358259542</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259556</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBName>threads</a:RoleBName>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>0..*</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,224={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,17=java.util.HashSet

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o73"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o71"/>
</c:Object2>
</o:Association>
<o:Association Id="o47">
<a:ObjectID>2EC17171-9BAB-4199-A5D4-4FB19494D867</a:ObjectID>
<a:Name>Association_17</a:Name>
<a:Code>association17</a:Code>
<a:CreationDate>1358353594</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353609</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o73"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o74"/>
</c:Object2>
</o:Association>
<o:Association Id="o49">
<a:ObjectID>09119BAB-0363-473D-BB9C-F60A257CA15D</a:ObjectID>
<a:Name>Association_16</a:Name>
<a:Code>association16</a:Code>
<a:CreationDate>1358353702</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358353714</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:RoleAIndicator>C</a:RoleAIndicator>
<a:RoleBVisibility>-</a:RoleBVisibility>
<a:RoleAMultiplicity>0..1</a:RoleAMultiplicity>
<a:RoleBMultiplicity>1..1</a:RoleBMultiplicity>
<a:ExtendedAttributesText>{D824A738-E160-11D2-B693-0008C7EA924D},Java,276={72FA5C48-5524-4DF7-8187-ABB19AB5AF9E},roleAContainer,6=&lt;None&gt;
{F6FFC71C-C472-4261-A710-B0BCC0BF4D58},roleAImplementationClass,6=&lt;None&gt;
{C11C9F66-6453-43A2-8824-6654518CF65A},roleBImplementationClass,6=&lt;None&gt;
{78C31404-0EE5-4FD0-9038-EE396B305F05},roleBContainer,6=&lt;None&gt;

</a:ExtendedAttributesText>
<c:Object1>
<o:Class Ref="o74"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o72"/>
</c:Object2>
</o:Association>
</c:Associations>
<c:Generalizations>
<o:Generalization Id="o52">
<a:ObjectID>EF1584A1-1C54-4383-B84A-2C8A3304F49E</a:ObjectID>
<a:Name>Generalisation_1</a:Name>
<a:Code>Generalisation_1</a:Code>
<a:CreationDate>1358255162</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255162</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o69"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o70"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o54">
<a:ObjectID>EFAA6DFD-3903-4EFA-A664-D526606647F4</a:ObjectID>
<a:Name>Generalisation_2</a:Name>
<a:Code>Generalisation_2</a:Code>
<a:CreationDate>1358255519</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255519</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o70"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o66"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o57">
<a:ObjectID>EBBD5971-DBFA-4B07-AF00-C2DBCED3E2C9</a:ObjectID>
<a:Name>Generalisation_3</a:Name>
<a:Code>Generalisation_3</a:Code>
<a:CreationDate>1358255808</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255810</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o70"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o67"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o59">
<a:ObjectID>FC28C450-3F9D-4A15-9D25-2803CF048CF2</a:ObjectID>
<a:Name>Generalisation_4</a:Name>
<a:Code>Generalisation_4</a:Code>
<a:CreationDate>1358255835</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358255837</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o70"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o68"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o15">
<a:ObjectID>DB3632C6-425F-4AF2-8C28-021257E487FC</a:ObjectID>
<a:Name>Generalisation_5</a:Name>
<a:Code>Generalisation_5</a:Code>
<a:CreationDate>1358258613</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258614</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o69"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o75"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o29">
<a:ObjectID>7A9A8D06-D9ED-49D6-AA64-D8B6D24F3C25</a:ObjectID>
<a:Name>Generalisation_6</a:Name>
<a:Code>Generalisation_6</a:Code>
<a:CreationDate>1358258864</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358258881</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o69"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o74"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o35">
<a:ObjectID>ADA0D13D-4A4A-4CD3-AC4E-884AE5A63BF6</a:ObjectID>
<a:Name>Generalisation_7</a:Name>
<a:Code>Generalisation_7</a:Code>
<a:CreationDate>1358259077</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259097</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o70"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o71"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o37">
<a:ObjectID>054CE78E-3A24-48C2-BF61-60C33FF5E33D</a:ObjectID>
<a:Name>Generalisation_8</a:Name>
<a:Code>Generalisation_8</a:Code>
<a:CreationDate>1358259135</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358259140</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<c:Object1>
<o:Class Ref="o69"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o72"/>
</c:Object2>
</o:Generalization>
</c:Generalizations>
<c:TargetModels>
<o:TargetModel Id="o101">
<a:ObjectID>6C97DADD-BFA7-4BD2-ABB1-783E9DD56490</a:ObjectID>
<a:Name>Java 1.x</a:Name>
<a:Code>Java</a:Code>
<a:CreationDate>1358254874</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358254874</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:TargetModelURL>file:///%_OBJLANG%/java.xol</a:TargetModelURL>
<a:TargetModelID>D824A738-E160-11D2-B693-0008C7EA924D</a:TargetModelID>
<a:TargetModelClassID>1811206C-1A4B-11D1-83D9-444553540000</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o3"/>
</c:SessionShortcuts>
</o:TargetModel>
<o:TargetModel Id="o102">
<a:ObjectID>77E32DA5-3E7A-44C6-8527-59A30BB50805</a:ObjectID>
<a:Name>WSDL for Java</a:Name>
<a:Code>WSDLJava</a:Code>
<a:CreationDate>1358254874</a:CreationDate>
<a:Creator>kone_a</a:Creator>
<a:ModificationDate>1358254874</a:ModificationDate>
<a:Modifier>kone_a</a:Modifier>
<a:TargetModelURL>file:///%_XEM%/WSDLJ2EE.xem</a:TargetModelURL>
<a:TargetModelID>C8F5F7B2-CF9D-4E98-8301-959BB6E86C8A</a:TargetModelID>
<a:TargetModelClassID>186C8AC3-D3DC-11D3-881C-00508B03C75C</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o4"/>
</c:SessionShortcuts>
</o:TargetModel>
</c:TargetModels>
</o:Model>
</c:Children>
</o:RootObject>

</Model>