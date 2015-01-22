import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobType

Job job = job(type: JobType.Freeform) {}
NewspaperUtilities.addAchernar(job)

job.with {
    name 'achernar-generate-presentation'
    steps {
        shell('set +e;\n' +
                'set +x;\n' +
                'ssh newspapr@achernar "source .bash_profile ; shopt -s huponexit; mkdir ~/cibuild; cd ~/cibuild; newspaper-hadoop-dissemination-component-*/bin/pollAndWork.sh </dev/null"')
    }

}
