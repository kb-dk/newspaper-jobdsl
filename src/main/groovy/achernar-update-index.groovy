import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Freeform) {}
NewspaperUtilities.addAchernar(job)

job.with {
    name 'achernar-update-index'
    label('Achernar_SBOI')
    triggers {
        cron("H/5 * * * *")
    }

    steps {
        shell('set +e\n' +
                'set +x\n' +
                'ssh doms@achernar "source .bash_profile ; shopt -s huponexit; ~/7880-cibuild/sboi-summarise/bin/ingest_update.sh  && ~/7880-cibuild/sboi-summarise/bin/index_update.sh < /dev/null &> /dev/null"')
    }
    publishers {
        downstream('achernar-invoke-batch-trigger', 'SUCCESS')
        downstream('achernar-ingest-metadata', 'SUCCESS')
        downstream('achernar-ingest-data', 'SUCCESS')
        downstream('achernar-check-structure', 'SUCCESS')
        downstream('achernar-generate-statistics', 'SUCCESS')
        downstream('achernar-check-metadata', 'SUCCESS')
        downstream('achernar-generate-histogram', 'SUCCESS')
        downstream('achernar-generate-jpylyzer', 'SUCCESS')
        downstream('achernar-generate-presentation', 'SUCCESS')
        downstream('achernar-enrich-batch', 'SUCCESS')
        downstream('achernar-generate-manualQA-flags', 'SUCCESS')
        downstream('achernar-approve-roundtrip', 'SUCCESS')
        downstream('achernar-update-edition-records', 'SUCCESS')
        downstream('achernar-update-title-records', 'SUCCESS')
    }
}
