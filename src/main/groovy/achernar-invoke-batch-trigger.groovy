import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Freeform) {}
NewspaperUtilities.addAchernar(job)

job.with {
    name 'achernar-invke-batch-trigger'
    steps {
        shell('set +e;\n' +
                'set +x;\n' +
                "ssh newspapr@achernar 'source .bash_profile ; shopt -s huponexit; ~/cibuild/batch-trigger-*/bin/trigger-on-new-batch.sh \$HOME/devel-config/batch-trigger-config/trigger-config.sh </dev/null'")
    }

}
